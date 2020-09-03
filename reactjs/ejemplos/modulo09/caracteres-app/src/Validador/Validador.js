import React from 'react'

const Validador = (props) => {
  let mensaje;
  if (props.longitud < 5){
    mensaje = <p>El valor de longitud {props.longitud} es muy corto</p>
  } else {
    mensaje = <p>El valor de longitud {props.longitud} es correcto</p>
  }
  return (
    <div>
      {mensaje}
    </div>
  )
}
export default Validador