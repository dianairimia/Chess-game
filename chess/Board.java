package chess;

//This class is partially implemented. Some methods need to have their body
//written, some other are fine as they are and other may need to be extended.

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board() {
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}
	}

	public static Square[][] getBoard() {
		return board;
	}

	public void initialisePieces() {
		// Blacks
		// rook
		Piece rook = new Rook(PieceColour.BLACK);
		rook.setSymbol("\u265C");
		setPiece(0,0,rook);
		// knight
		Piece knight = new Knight(PieceColour.BLACK);
		knight.setSymbol("\u265E");
		setPiece(0,1,knight);
		// bishop
		Piece bishop = new Bishop(PieceColour.BLACK);
		bishop.setSymbol("\u265D");
		setPiece(0,2,bishop);
		// queen
		Piece queen = new Queen(PieceColour.BLACK);
		queen.setSymbol("\u265B");
		setPiece(0,3,queen);
		// king
		Piece king = new King(PieceColour.BLACK);
		king.setSymbol("\u265A");
		setPiece(0,4,king);
		// bishop
		bishop = new Bishop(PieceColour.BLACK);
		bishop.setSymbol("\u265D");
		setPiece(0,5,bishop);
		// knight
		knight = new Knight(PieceColour.BLACK);
		knight.setSymbol("\u265E");
		setPiece(0,6,knight);
		// rook
		rook = new Rook(PieceColour.BLACK);
		rook.setSymbol("\u265C");
		setPiece(0,7,rook);
		// pawn
		Piece pawn;
		for (int i=0; i<board[0].length; i++){
			pawn = new Pawn(PieceColour.BLACK);
			pawn.setSymbol("\u265F");
			setPiece(1,i,pawn);
		}

		// Whites
		// rook
		rook = new Rook(PieceColour.WHITE);
		rook.setSymbol("\u2656");
		setPiece(board[0].length-1,0,rook);
		// knight
		knight = new Knight(PieceColour.WHITE);
		knight.setSymbol("\u2658");
		setPiece(board[0].length-1,1,knight);
		// bishop
		bishop = new Bishop(PieceColour.WHITE);
		bishop.setSymbol("\u2657");
		setPiece(board[0].length-1,2,bishop);
		// queen
		queen = new Queen(PieceColour.WHITE);
		queen.setSymbol("\u2655");
		setPiece(board[0].length-1,3,queen);
		// king
		king = new King(PieceColour.WHITE);
		king.setSymbol("\u2654");
		setPiece(board[0].length-1,4,king);
		// bishop
		bishop = new Bishop(PieceColour.WHITE);
		bishop.setSymbol("\u2657");
		setPiece(board[0].length-1,5,bishop);
		// knight
		knight = new Knight(PieceColour.WHITE);
		knight.setSymbol("\u2658");
		setPiece(board[0].length-1,6,knight);
		// rook
		rook = new Rook(PieceColour.WHITE);
		rook.setSymbol("\u2656");
		setPiece(board[0].length-1,7,rook);
		// pawn
		for (int i=0; i<board[0].length; i++) {
			pawn = new Pawn(PieceColour.WHITE);
			pawn.setSymbol("\u2659");
			setPiece(board[0].length-2,i,pawn);
		}
	}

	public void printBoard() {
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp = " ";
		String bar= "|" ;
		for (int i=0; i<board[0].length; i++) {
			int row=i+1;
				for (int j=0; j<board[1].length; j++) {
					if ((j==0) && board[i][j].hasPiece())
						System.out.print(row + " " + board[i][j].getPiece().getSymbol());
					else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row + "  " );
						else if ((j==7) && board[i][j].hasPiece())
								System.out.print("|" + board[i][j].getPiece().getSymbol());
					else if (board[i][j].hasPiece())
						System.out.print("|" + board[i][j].getPiece().getSymbol());
					else
						System.out.print("| ");
				}
				System.out.print("  " + row + "\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");
	}

	// the function returns true only when the king is captured
	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p) {
		// isKing is false so we assume the king has not been captured yet
		boolean isKing = false;
		if(p.isLegitMove(i0, j0, i1, j1) == true) {
			if (board[i1][j1].hasPiece()) {
				// checking the symbol for the king piece - if true isKing is true
				if (board[i1][j1].getPiece().getSymbol().equals("\u2654") ||
						board[i1][j1].getPiece().getSymbol().equals("\u265A")) {
							isKing = true;
						}
			}
			// moves the piece anyway
			board[i0][j0].getPiece().updateCoordinates(i1, j1);
			board[i0][j0].removePiece();
			this.setPiece(i1, j1, p);
		}
		return isKing;
	}

 // puts a piece on a specific square
	public void setPiece(int iIn, int jIn, Piece p) {
		this.board[iIn][jIn].setPiece(p);
	}

	// returns a piece on the given coordinates
	public Piece getPiece(int iIn, int jIn) {
		return board[iIn][jIn].getPiece();
	}

	// returns true is a piece is on the given coordinates
	public boolean hasPiece(int i, int j) {
		return board[i][j].hasPiece();
	}

}
