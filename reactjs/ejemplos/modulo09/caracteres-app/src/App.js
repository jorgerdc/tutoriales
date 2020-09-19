import React, { Component } from 'react';
import './App.css';
import Validador from './Validador/Validador'; 


class App extends Component {
  /**
   * Estado del componente
   */
  state ={
    texto : ''
  }

  /** 
   * Método empleado para manejar el evento onChange. Notar que se
   * hace uso de una variable para hacer referencia a dicho método
   */
  textoOnChangeHandler = (event) => {
    this.setState({texto: event.target.value});
  }

  render() {
    return (
      <div className="App">
        <h1>App Caracteres</h1>
        <hr/>
        <p>Capturar alg&uacute;n texto:<br/></p>
        <form>
          <input 
            type="text"
            onChange={this.textoOnChangeHandler}
            value={this.state.texto}/>
        </form>
        <p>{this.state.texto}</p>
        <Validador longitud={this.state.texto.length}/>
      </div>  
    );
  }
}

export default App;
