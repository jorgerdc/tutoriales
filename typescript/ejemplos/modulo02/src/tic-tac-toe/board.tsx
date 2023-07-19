import React from 'react';
import Square from './square';
import { SquareValues } from './game';

interface BoardProperties {
  squares: SquareValues[];
  onClick: (i: number) => void;
}

class Board extends React.Component<BoardProperties> {

  renderSquare(i: any): JSX.Element {
    return <Square value={this.props.squares[i]} onClick={() => this.props.onClick(i)} />;
  }

  render(): JSX.Element {
    return (
      <div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }
}

export default Board;
