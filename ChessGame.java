import java.util.ArrayList;

public class ChessGame {
    public static void main(String[] args) {
        ChessBoard gameBoard = new ChessBoard();
        gameBoard.fillBoardDefault();
//        ArrayList<ChessPosition> kamal = gameBoard.pieces[1][0].getAllPossibleMoves(gameBoard);
//        for(int i = 0; i < kamal.size(); i++){
//            System.out.println(kamal.get(i).getRank() +" " + kamal.get(i).getFile());
//        }
        char startingColor = 'w';
        while(true){
            ChessCLI.renderBoard(gameBoard);
            ChessCLI.getUserMove(gameBoard,startingColor);
            startingColor = Helpers.invertColor(startingColor);
        }
    }
}
