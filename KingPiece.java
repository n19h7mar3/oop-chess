import java.util.ArrayList;

public class KingPiece extends ChessPiece {

    KingPiece(char color, ChessPosition position)  {
        super(color, position);
        this.pieceName = "king";
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board) {
        ArrayList<ChessPosition> moves = new ArrayList<>();

        char curFile = position.getFile();
        char curRank = position.getRank();

        for (int f= curFile-1; f = curFile+1; f++){
            for(int r = curRank -1 ; r =curRank +1; r++){
                ChessPosition thispos = new ChessPosition(f, r);
                if(thispos = position){
                    continue;
                }
                if( board.isFriendlyPieceAtPostion(thispos)){
                    break;
                }
                if(board.isEnemyPieceAtPosition(thispos)){
                    moves.add(thispos);
                    break;
                }
                if(ChessPosition.isValidPosition(thispos)){
                    moves.add(thispos);
                }
            }
        }
 
        return moves;
    }
}
