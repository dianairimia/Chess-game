package chess;

public class Queen extends Piece{
  public Queen(PieceColour newColour){
    this.colour = newColour;
  }

  @Override
  public  boolean isLegitMove(int i0, int j0, int i1, int j1){
    Rook rook = new Rook(colour);
    Bishop bishop = new Bishop(colour);
    // queen can move like a rook or bishop
    return rook.isLegitMove(i0, j0, i1, j1) ||
          bishop.isLegitMove(i0, j0, i1, j1);
  }

}
