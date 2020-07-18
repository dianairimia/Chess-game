package chess;

public class Bishop extends Piece {
  public Bishop(PieceColour newColour){
    this.colour = newColour;
  }

  @Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1){

    if (this.colour == Board.getBoard()[i0][j0].getPiece().getColour()) {
      if ((i0 == i1) || (j0 == j1))
        return false;
      else if ((Math.abs(i0 - i1)) != (Math.abs(j0 - j1)))
        return false;
      /* if the piece at the finallCoords is one of the player's pieces
          return false -  must not capture it */
      else if (Board.getBoard()[i1][j1].hasPiece() &&
          Board.getBoard()[i1][j1].getPiece().getColour() == this.colour)
          return false;
      else {
        // if i0 - i1 it goes down
        int countI = (i0 < i1) ? 1 : -1;
        // if j0 - j1 it goes to the right
        int countJ = (j0 < j1) ? 1 : -1;
        int move = j0 + countJ;

        // moves diagonally by rows then increses the columns
        for (int k = i0 + countI; k != i1; k += countI) {
          if (Board.getBoard()[k][move].hasPiece() == true)
            return false;
          move += countJ;
        }
      }
      return true;
    }
    return false;
  }

}
