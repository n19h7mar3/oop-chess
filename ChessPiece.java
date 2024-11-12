import java.util.ArrayList;

abstract class ChessPiece {
    protected char color;
    protected String pieceType;
    public ChessPosition position;

    ChessPiece(char color, ChessPosition position) {
        if (color != 'w' && color != 'b') {
            throw new IllegalArgumentException("ChessPiece: Invalid color specified.");
        }

        this.color = color;
        this.position = position;
    }

    char getColor() { return this.color; }
    String getPieceType() { return this.pieceType; }

    abstract ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board);
}
