package chess;

public class CheckInput {

	// function returns true if the input matches the requested format or is "END"
	public boolean checkCoordinateValidity(String input) {
		return input.matches("[1-8][a-h]") || input.equals("END");
	}

}
