import java.util.ArrayList;

public class KingPiece extends ChessPiece {

    KingPiece(char color, ChessPosition position)  {
        super(color, position);
        this.pieceType = "king";
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board) {
        ArrayList<ChessPosition> moves = new ArrayList<>();

        int curFile = position.getFile();
        int curRank = position.getRank();

        for (int f= curFile-1; f <= curFile+1; f++){
            for(int r = curRank -1 ; r <=curRank +1; r++){
                ChessPosition thispos = new ChessPosition(f, r);
                if(thispos.equals (position)){
                    continue;
                }
                if (addMoveIfValidAndIndicateWhetherToContinue(moves, board, f, r)) break;
                }
            }
        
 
        return moves;
    }
}
