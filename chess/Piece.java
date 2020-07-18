package chess;

public abstract class Piece {
  private int row;
  private int column;
  private String symbol;
  protected PieceColour colour;

  public Piece() {
    this.symbol = symbol;
    this.colour = colour;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String newSymbol) {
    this.symbol = newSymbol;
  }

  public PieceColour getColour() {
    return colour;
  }

  public void updateCoordinates(int newRow, int newColumn) {
    this.row = newRow;
    this.column = newColumn;
  }

  // will override this method in all classes that inherit from Piece
  public abstract boolean isLegitMove(int i0, int j0, int i1, int j1);
}
