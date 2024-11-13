import java.util.ArrayList;

class ChessBoard {
    ChessPiece[][] pieces = new ChessPiece[8][8];
    ArrayList<ChessPiece> capturedByWhite = new ArrayList<>();
    ArrayList<ChessPiece> capturedByBlack = new ArrayList<>();
    ChessBoard(){
        fillBoardDefault();
    }

    boolean isAnyPieceOfSpecificColorAtPosition(ChessPosition position, char color) {
        if(pieces[8-position.getRank()][position.getFile()-1] != null && pieces[8-position.getRank()][position.getFile()-1].color == color){
            return true;
        }
        return false;
    }
    boolean isThereAPiece(int rank, int file){
        return pieces[8 - rank][file - 1] != null;
    }
    public void fillBoardDefault(){

        //Pawn pieces
        for(int i=1; i<=8; i++){
            pieces[8-2][i-1] = new PawnPiece('w',new ChessPosition(i,2));
        }
        for(int i=1; i<=8; i++){
            pieces[8-7][i-1] = new PawnPiece('b', new ChessPosition(i,7));
        }

        int rowForWhiteExecutivePieces = 8-1;
        int rowForBlackExecutivePieces = 8-8;

        //Rock Pieces
        pieces[rowForWhiteExecutivePieces][1-1] = new RookPiece('w',new ChessPosition(1,1));
        pieces[rowForWhiteExecutivePieces][8-1] = new RookPiece('w',new ChessPosition(8,1));
        pieces[rowForBlackExecutivePieces][1-1] = new RookPiece('b',new ChessPosition(1,8));
        pieces[rowForBlackExecutivePieces][8-1] = new RookPiece('b',new ChessPosition(8,8));

        //Knight Pieces
        pieces[rowForWhiteExecutivePieces][2-1] = new KnightPiece('w',new ChessPosition(2,1));
        pieces[rowForWhiteExecutivePieces][7-1] = new KnightPiece('w',new ChessPosition(7,1));
        pieces[rowForBlackExecutivePieces][2-1] = new KnightPiece('b',new ChessPosition(2,8));
        pieces[rowForBlackExecutivePieces][7-1] = new KnightPiece('b',new ChessPosition(7,8));

        //Bishop Pieces
        pieces[rowForWhiteExecutivePieces][3-1] = new BishopPiece('w',new ChessPosition(3,1));
        pieces[rowForWhiteExecutivePieces][6-1] = new BishopPiece('w',new ChessPosition(6,1));
        pieces[rowForBlackExecutivePieces][3-1] = new BishopPiece('b',new ChessPosition(3,8));
        pieces[rowForBlackExecutivePieces][6-1] = new BishopPiece('b',new ChessPosition(6,8));

        //King Pieces
        pieces[rowForWhiteExecutivePieces][5-1] = new KingPiece('w', new ChessPosition(5,1));
        pieces[rowForBlackExecutivePieces][5-1] = new KingPiece('b', new ChessPosition(5,8));

        //Queen Pieces
        pieces[rowForWhiteExecutivePieces][4-1] = new QueenPiece('w', new ChessPosition(4,1));
        pieces[rowForBlackExecutivePieces][4-1] = new QueenPiece('b', new ChessPosition(4,8));
    }
}
