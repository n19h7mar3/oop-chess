import java.util.ArrayList;

public class QueenPiece extends ChessPiece {

    QueenPiece(char color, ChessPosition position)  {
        super(color, position);
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board) {
        ArrayList<ChessPosition> moves = new ArrayList<>();
        RookPiece rook = new RookPiece(this.color, this.position);
        moves.addAll(rook.getAllPossibleMoves(board));
        BishopPiece bishop = new BishopPiece(this.color, this.position);
        moves.addAll(bishop.getAllPossibleMoves(board));
        
        
        return moves;
    }
}
