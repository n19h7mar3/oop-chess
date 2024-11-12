import java.util.ArrayList;
public class PawnPiece extends ChessPiece {
    PawnPiece(char color, ChessPosition position)  {
        super(color, position);
        this.pieceType = "pawn";
    }
    @Override
    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board) {
        ArrayList<ChessPosition> moves = new ArrayList<>();
        int curRank = position.getRank();
        int curFile = position.getFile();

        if(color == 'w'){
            if(board.pieces[curRank+1][curFile] == null) {
                moves.add(new ChessPosition(curRank + 1, curFile));
            }

            if(curRank == 2 && board.pieces[curRank+2][curFile] == null && board.pieces[curRank + 1][curFile] == null){
                moves.add(new ChessPosition(curRank+2,curFile));
            }

            if(curFile-1>=1 && board.isAnyPieceOfSpecificColorAtPosition(new ChessPosition(curRank+1,curFile-1),'b')){
                moves.add(new ChessPosition(curRank+1,curFile-1));
            }

            if(curFile+1<=8 && board.isAnyPieceOfSpecificColorAtPosition(new ChessPosition(curRank+1,curFile+1),'b') ){
                moves.add(new ChessPosition(curRank+1,curFile+1));
            }

        }else{
            if(board.pieces[curRank-1][curFile] == null) {
                moves.add(new ChessPosition(curRank - 1, curFile));
            }

            if(curRank == 7 && board.pieces[curRank-2][curFile] == null && board.pieces[curRank - 1][curFile] == null){
                moves.add(new ChessPosition(curRank-2,curFile));
            }

            if(curFile-1>=1 && board.isAnyPieceOfSpecificColorAtPosition(new ChessPosition(curRank-1,curFile-1),'w')){
                moves.add(new ChessPosition(curRank-1,curFile-1));
            }

            if(curFile+1<=8 && board.isAnyPieceOfSpecificColorAtPosition(new ChessPosition(curRank-1,curFile+1),'w')){
                moves.add(new ChessPosition(curRank-1,curFile+1));
            }
        }
        return moves;
    }
}