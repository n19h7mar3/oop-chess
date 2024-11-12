import java.util.ArrayList;

class ChessBoard {
    ChessPiece[][] pieces = new ChessPiece[8][8];
    ArrayList<ChessPiece> capturedByWhite = new ArrayList<>();
    ArrayList<ChessPiece> capturedByBlack = new ArrayList<>();

    boolean isFriendlyPieceAtPostion(ChessPosition position, String myColor) {
        return false; // TODO implement this
    }

    boolean isEnemyPieceAtPosition(ChessPosition position, String myColor) {
        return false; // TODO implement this
    }
}
