package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd = false;

	public Game() {
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();
		boolean white = true;
		while (!gameEnd) {
			//write the game logic
			Console console = System.console();
			CheckInput c = new CheckInput();
			String initialCoords="";
			String finalCoords="";

			if (white) {
				System.out.println("\n------Whites move-----");
				// get input from the whites player
				do {
					initialCoords = console.readLine("> Enter origin: ");
					while (c.checkCoordinateValidity(initialCoords) == false) {
						System.out.println("> Invalid origin. Try again.");
						initialCoords = console.readLine("> Enter origin: ");
					}
					if (initialCoords.equals("END")) {
						gameEnd = true;
						System.out.println("\nB L A C K S   W O N !!!");
						break;
					}
					finalCoords = console.readLine("> Enter destination: ");
					while (c.checkCoordinateValidity(finalCoords) == false) {
						System.out.println("> Invalid destination. Try again.");
						finalCoords = console.readLine("> Enter destination: ");
					}
					if (finalCoords.equals("END")) {
						gameEnd = true;
						System.out.println("\nB L A C K S   W O N !!!");
						break;
					}
					// whites turn ends
					white = false;
				} while (white);
			}
			else {
				System.out.println("\n------Blacks move-----");
				// get input from the whites player
				do {
					initialCoords = console.readLine("> Enter origin: ");
					while (c.checkCoordinateValidity(initialCoords) == false) {
						System.out.println("> Invalid origin. Try again.");
						initialCoords = console.readLine("> Enter origin: ");
					}
					if (initialCoords.equals("END")) {
						gameEnd = true;
						System.out.println("\nW H I T E S   W O N !!!");
						break;
					}
					finalCoords = console.readLine("> Enter destination: ");
					while (c.checkCoordinateValidity(finalCoords) == false) {
						System.out.println("> Invalid destination. Try again.");
						finalCoords = console.readLine("> Enter destination: ");
					}
					if (finalCoords.equals("END")) {
						gameEnd = true;
						System.out.println("\nW H I T E S   W O N !!!");
						break;
					}
					// blacks turn ends
					white = true;
				} while (!white);
			}

			if(!gameEnd) {
				// first character will be a digit and the second one a letter
				int iInitial = Character.getNumericValue(initialCoords.charAt(0))-1;
				int jInitial = colToInt(initialCoords.charAt(1));
				int iFinal = Character.getNumericValue(finalCoords.charAt(0))-1;
				int jFinal = colToInt(finalCoords.charAt(1));
				Piece xPiece = b.getPiece(iInitial, jInitial);
				// check if the piece on the initialCoords exists
				if(b.getBoard()[iInitial][jInitial].hasPiece()) {
					if(!white) {
						/*check if the piece blacks want to move is black or the move is
						not legit*/
						if ((xPiece.getColour() == PieceColour.BLACK)
								|| !(xPiece.isLegitMove(iInitial,jInitial, iFinal, jFinal))) {
								white = true;
								System.out.println("Incorrect move. Try again.");
						}
						else	if (b.movePiece(iInitial, jInitial, iFinal, jFinal,
														b.getPiece(iInitial, jInitial)) == true){
									b.printBoard();
									System.out.println("\nW H I T E S   W O N !!!");
									gameEnd = true;
									break;
									}
							}
					else {
						/*check if the piece whites want to move is white or the move is
						not legit*/
						if ((xPiece.getColour() == PieceColour.WHITE)
								|| !(xPiece.isLegitMove(iInitial,jInitial, iFinal, jFinal))) {
								white = false;
								System.out.println("Incorrect move. Try again.");
						}
						else	if (b.movePiece(iInitial, jInitial, iFinal, jFinal,
														b.getPiece(iInitial, jInitial)) == true){
									b.printBoard();
									System.out.println("\nB L A C K S   W O N !!!");
									gameEnd = true;
									break;
									}
							}
					b.printBoard();
				}
				/* if the piece on the initialCoords does not exist the user enters
				the coords again*/
				else {
						if(!white) {
							white = true;
							System.out.println("Incorrect move. Try again.");
						}
						else {
							white = false;
							System.out.println("Incorrect move. Try again.");
						}
				}
			}
		}
	}

// transforms the second character of the input to an int - the column
 public int colToInt(char x) {
	 switch(x) {
		 case 'a':
		 	return 0;
		case 'b':
 		 	return 1;
		case 'c':
 		 	return 2;
		case 'd':
 		 	return 3;
		case 'e':
	 		return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
	 }
	 return -1;
 }

	public static void main (String args[]){
		Game g  = new Game();
	}

}
