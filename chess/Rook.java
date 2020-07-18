package chess;

import java.lang.Math;
import chess.Board;

public class Rook extends Piece {
  public Rook(PieceColour newColour) {
    this.colour = newColour;
  }

  @Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1) {
    if (this.colour == Board.getBoard()[i0][j0].getPiece().getColour()) {
      if ((i0 == i1) != (j0 == j1)) {
        /* if the piece at the finallCoords is one of the player's pieces
            return false -  must not capture it */
        if (Board.getBoard()[i1][j1].hasPiece() &&
            Board.getBoard()[i1][j1].getPiece().getColour() == this.colour)
                return false;
        else if (i0 == i1) { //horizontal move
          int count = (j0 < j1) ? 1 : -1;
          for (int k = j0 + count; k != j1; k += count) {
            if (Board.getBoard()[i1][k].hasPiece() == true)
              return false;
          }
        }
        else if (j0 == j1) { //vertical move
          int count = (i0 < i1) ? 1 : -1;
          for (int k = i0 + count; k != i1; k += count) {
            if (Board.getBoard()[k][j0].hasPiece() == true)
              return false;
          }
        }
        return true;
      }
    }
    return false;
  }

}
