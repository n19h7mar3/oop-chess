import java.util.ArrayList;

public class KnightPiece extends ChessPiece {

    KnightPiece(char color, ChessPosition position) {
        super(color, position);
        this.pieceType = "knight";
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board) {
        ArrayList<ChessPosition> moves = new ArrayList<>();

        int curFile = position.getFile();
        int curRank = position.getRank();

        int tempRank = curRank + 2;
        for(int i = 1; i <= 2; i++) {
            addMoveIfValid(moves, board, curFile + i, tempRank);  // Top Right Move
            addMoveIfValid(moves, board, curFile - i, tempRank);  // Top Left Move
            tempRank -= 1;
        }

        tempRank = curRank - 2;
        for(int i = 1; i <= 2; i++) {
            addMoveIfValid(moves, board, curFile + i, tempRank);  // Bottom Right Move
            addMoveIfValid(moves, board, curFile - i, tempRank);  // Bottom Left Move
            tempRank += 1;
        }

        return moves;
    }

    void addMoveIfValid(ArrayList<ChessPosition> moves, ChessBoard board, int file, int rank) {
        // Make sure proposed move is not out-of-bounds
        if (!ChessPosition.isValidPosition(file, rank)) return;

        ChessPosition newPos = new ChessPosition(file, rank);

        // Make sure any friendly piece is not at proposed position
        if (board.isAnyPieceOfSpecificColorAtPosition(newPos, this.color)) return;

        // newPos is a valid move
        moves.add(newPos);
    }
}
