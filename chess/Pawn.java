package chess;

import java.lang.Math;
import chess.Board;

public class Pawn extends Piece {
	public Pawn(PieceColour newColour) {
		this.colour = newColour;
	}

	@Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (Math.abs(i0 - i1) > 2 || Math.abs(j0 - j1) > 1)
			return false;
		else {
			if (this.colour == PieceColour.WHITE) {
				if (Board.getBoard()[i1][j1].hasPiece() == true
						&& Board.getBoard()[i1][j1].getPiece().getColour()
							== PieceColour.BLACK) {
								/* if the piece the white pawn wants to capture is black then
								check diagonals - the only way it can capture a piece */
					if ((Math.abs(j0 - j1) == 1) && (Math.abs(i0 - i1) == 1))
						return true;
				}
				else {
						if ((i0 == 6 && i1 == 4) && (j0 == j1) &&
								(Board.getBoard()[5][j1].hasPiece() == false))
							return true;
						else if (i0 == (i1 + 1) && ((Math.abs(j0 - j1) == 0))
										&& (Board.getBoard()[i1][j1].hasPiece() == false))
							return true;
						}
					return false;
			}
			else if (this.colour == PieceColour.BLACK) {
				if (Board.getBoard()[i1][j1].hasPiece() == true
						&& Board.getBoard()[i1][j1].getPiece().getColour()
							== PieceColour.WHITE) {
								/* if the piece the black pawn wants to capture is white then
								check diagonals - the only way it can capture a piece */
					if ((Math.abs(j0 - j1) == 1) && (Math.abs(i0 - i1)==1))
						return true;
				}
				else {
							if ((i0 == 1 && i1 == 3) && (j0 == j1) &&
									(Board.getBoard()[2][j1].hasPiece() == false))
								return true;
							else if (i0 == (i1 - 1) && ((Math.abs(j0 - j1) == 0))
											&& (Board.getBoard()[i1][j1].hasPiece() == false))
								return true;
						}
					return false;
  		}
		}
		return false;
	}

}
