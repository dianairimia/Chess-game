package chess;

import java.lang.Math;

public class Knight extends Piece {
  public Knight(PieceColour newColour) {
    this.colour = newColour;
  }

  @Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1) {
    if (Board.getBoard()[i1][j1].hasPiece()) {
      // check if the player wants to move its own piece
      if (this.colour == Board.getBoard()[i1][j1].getPiece().getColour())
        return false;
    }
    if ((Math.abs(i0 - i1) == 2) && (Math.abs(j0 - j1) == 1))
      return true;
    else if ((Math.abs(i0 - i1) == 1) && (Math.abs(j0 - j1) == 2))
      return true;
    else
      return false;
}
}
