package chess;

import java.lang.Math;
// there is no board parameter in isLegitMove() so need to import Board class
import chess.Board;

public class King extends Piece{
	public King(PieceColour newColour){
    this.colour = newColour;
  }

	@Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (Board.getBoard()[i1][j1].hasPiece()) {
			// check if the player wants to move its own piece
      if (this.colour == Board.getBoard()[i1][j1].getPiece().getColour())
        return false;
    }
		int iCoords = Math.abs(i0 - i1);
		int jCoords = Math.abs(j0 - j1);
		/* the king can move in the "square" around him (front, back, diagonal)
		by one square */
		if (iCoords + jCoords == 1)
			return true;
		else if (iCoords == 1 && jCoords == 1)
			return true;
		return false;
  }

}
