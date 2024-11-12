import java.util.ArrayList;

class ChessBoard {
    ChessPiece[][] pieces = new ChessPiece[8][8];
    ArrayList<ChessPiece> capturedByWhite = new ArrayList<>();
    ArrayList<ChessPiece> capturedByBlack = new ArrayList<>();

    boolean isAnyPieceOfSpecificColorAtPosition(ChessPosition position, char color) {
        return false; // TODO implement this
    }
}
