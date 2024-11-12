import java.util.ArrayList;
public class RookPiece extends ChessPiece {

    RookPiece(char color, ChessPosition position)  {
        super(color, position);
        this.pieceType = "rook";
    }

    ArrayList<ChessPosition> getAllPossibleMoves(ChessBoard board){
        ArrayList<ChessPosition> moves = new ArrayList<>();

        int curFile = position.getFile();
        int curRank = position.getRank();

        for(int r = curRank + 1; r <= 8; r++){

            ChessPosition thisPos = new ChessPosition(curFile, r);

            if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,color)) break;

            if(color == 'b' && board.isAnyPieceOfSpecificColorAtPosition(thisPos,'w')){
                moves.add(thisPos);
                break;
            }else if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,'b')){
                moves.add(thisPos);
                break;
            }

            if (ChessPosition.isValidPosition(thisPos.getFile(),thisPos.getRank()) && !thisPos.equals(position)) {

                moves.add(thisPos);

            }
        }

        for(int r = curRank - 1; r >= 1; r--){

            ChessPosition thisPos = new ChessPosition(curFile, r);

            if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,color)) break;
            if(color == 'b' && board.isAnyPieceOfSpecificColorAtPosition(thisPos,'w')){
                moves.add(thisPos);
                break;
            }else if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,'b')){
                moves.add(thisPos);
                break;
            }

            if (ChessPosition.isValidPosition(thisPos.getFile(),thisPos.getRank()) && !thisPos.equals(position)) {

                moves.add(thisPos);

            }
        }

        for(int f = curFile + 1; f <= 8; f++){

            ChessPosition thisPos = new ChessPosition(f, curRank);

//            if (board.isFriendlyPieceAtPostion(thisPos)) break;
            if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,color)) break;

//            if (board.isEnemyPieceAtPosition(thisPos)){
//                moves.add(thisPos);
//                break;
//            }
            if(color == 'b' && board.isAnyPieceOfSpecificColorAtPosition(thisPos,'w')){
                moves.add(thisPos);
                break;
            }else if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,'b')){
                moves.add(thisPos);
                break;
            }

            if (ChessPosition.isValidPosition(thisPos.getFile(),thisPos.getRank()) && !thisPos.equals(position)) {

                moves.add(thisPos);

            }
        }

        for(int f = curFile - 1; f >= 1; f--){

            ChessPosition thisPos = new ChessPosition(f, curRank);

//            if (board.isFriendlyPieceAtPostion(thisPos)) break;
            if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,color)) break;
//            if (board.isEnemyPieceAtPosition(thisPos)){
//                moves.add(thisPos);
//                break;
//            }
            if(color == 'b' && board.isAnyPieceOfSpecificColorAtPosition(thisPos,'w')){
                moves.add(thisPos);
                break;
            }else if(board.isAnyPieceOfSpecificColorAtPosition(thisPos,'b')){
                moves.add(thisPos);
                break;
            }

            if (ChessPosition.isValidPosition(thisPos.getFile(),thisPos.getRank()) && !thisPos.equals(position)) {

                moves.add(thisPos);

            }
        }

        return moves;
    }
}