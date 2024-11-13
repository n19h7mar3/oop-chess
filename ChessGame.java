public class ChessGame {
    public static void main(String[] args) {
        ChessBoard gameBoard = new ChessBoard();
        gameBoard.fillBoardDefault();
        ChessCLI.renderBoard(gameBoard);
       ChessCLI.getUserMove(gameBoard,'w');
       ChessCLI.renderBoard(gameBoard);
    }
}
