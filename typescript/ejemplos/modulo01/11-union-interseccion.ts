interface Bird {
  fly(): void;
  layEggs(): void;
}

interface Fish {
  swim(): void;
  layEggs(): void;
}

declare function getSmallPet(): Fish | Bird; // unión

let pet: Fish | Bird = getSmallPet();
pet.layEggs(); // Disponible en sus 2 posibles tipos
// pet.swim(); // Solo disponible en uno de sus tipos: Property 'swim' does not exist on type 'Bird | Fish'.

type NetworkLoadingState = {
  state: 'loading';
};

type NetworkFailedState = {
  state: 'failed';
  code: number;
};

type NetworkSuccessState = {
  state: 'success';
  response: {
    title: string;
    duration: number;
    summary: string;
  };
};

// Creamos un tipo que representa uno de los tipos de arriba, pero aún no sabemos cual es
type NetworkState = NetworkLoadingState | NetworkFailedState | NetworkSuccessState;

function networkStatus(state: NetworkState): string {
  // console.log(state.code); // Property 'code' does not exist on type 'NetworkState'.
  switch (state.state) {
    case 'loading':
      return 'Descargando...';
    case 'failed':
      return `Error ${state.code} descargando`;
    case 'success':
      return `Descargado ${state.response.title} - ${state.response.summary}`;
  }
}

interface ManejadorDeErrores {
  success: boolean;
  error?: { message: string };
}

interface Articulos {
  articulos: { title: string }[];
}

type RespuestaDeArticulos = Articulos & ManejadorDeErrores;

const handler = (response: RespuestaDeArticulos) => {
  if (response.error) {
    console.log(response.error.message);
    throw response.error;
  }
  console.log(response.articulos);
};
