import java.util.ArrayList;

class ChessBoard {
    ChessPiece[][] pieces = new ChessPiece[8][8];
    ArrayList<ChessPiece> capturedByWhite = new ArrayList<>();
    ArrayList<ChessPiece> capturedByBlack = new ArrayList<>();

    boolean isAnyPieceOfSpecificColorAtPosition(ChessPosition position, char color) {
        if(pieces[8-position.getRank()][position.getFile()-1] != null && pieces[8-position.getRank()][position.getFile()-1].color == color){
            return true;
        }
        return false;
    }
    boolean isThereAPiece(int rank, int file){
        return pieces[8 - rank][file - 1] != null;
    }
}
