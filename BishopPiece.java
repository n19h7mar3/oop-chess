import java.util.ArrayList;

public class BishopPiece extends ChessPiece {

    BishopPiece(char color, ChessPosition position) {
        super(color, position);
        this.pieceType = "bishop";
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board){
        ArrayList<ChessPosition> moves = new ArrayList<>();

        int curFile = position.getFile();
        int curRank = position.getRank();

        for (int r = curRank + 1; r <= 8; r++) {
            for (int f = curFile + 1; f <= 8; f++) {
                if (!addMoveIfValidAndIndicateWhetherToContinue(moves, board, f, r)) break;
            }
        }

        for (int r = curRank - 1; r >= 1; r--) {
            for (int f = curFile + 1; f <= 8; f++) {
                if (!addMoveIfValidAndIndicateWhetherToContinue(moves, board, f, r)) break;
            }
        }

        for (int r = curRank + 1; r <= 8; r++) {
            for (int f = curFile - 1; f >= 1; f--) {

                if (!addMoveIfValidAndIndicateWhetherToContinue(moves, board, f, r)) break;
            }
        }

        for (int r = curRank - 1; r >= 1; r--) {
            for (int f = curFile + 1; f <= 8; f++) {
                if (!addMoveIfValidAndIndicateWhetherToContinue(moves, board, f, r)) break;
            }
        }

        return moves;
    }
}
