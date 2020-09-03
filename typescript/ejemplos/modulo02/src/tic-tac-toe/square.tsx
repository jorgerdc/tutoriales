import React from 'react';

interface SquareProperties {
  value: any;
  onClick: () => void;
}

function Square(props: SquareProperties): JSX.Element {
  return (
    <button className="square" onClick={props.onClick}>
      {props.value}
    </button>
  );
}

export default Square;
