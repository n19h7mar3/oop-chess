import java.util.HashMap;
import java.util.Scanner;

public class ChessCLI {
    static ChessBoard board = new ChessBoard();
    public static void renderBoard(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        display();
        System.out.print("\nPieces Captured By White: ");
        System.out.println(board.capturedByWhite.toString());
        System.out.print("Pieces Captured By Black: ");
        System.out.println(board.capturedByBlack.toString());
    }
    public static void getUserMove(char color){
        Scanner sc = new Scanner(System.in);
        if(color == 'w'){
            System.out.print("Enter white's move: ");
        }else{
            System.out.print("Enter black's move");
        }
        String input = sc.nextLine();
        char currentRank = input.charAt(0);
        char currentField = input.charAt(1);
        char nextRank = input.charAt(3);
        char nextField = input.charAt(4);
    }
    public static void display(){
        System.out.println("\t  1\t\t  2\t\t  3\t\t  4\t\t  5\t\t  6\t\t  7\t\t  8");
        System.out.println("   ---------------------------------------------------------------");

        for (int i = 0; i < 8; i++) {
            System.out.print((i) + " |");

            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.pieces[i][j];
                if (piece==null) {
                    System.out.print("   .   ");
                } else {
                    System.out.print("   " + convertNameToIcon(piece.pieceType, piece.color)+ "  ");
                }
                System.out.print("|");
            }

            System.out.println(" " + (i));
            System.out.println("   ---------------------------------------------------------------");
        }

        System.out.println("\t  1\t\t  2\t\t  3\t\t  4\t\t  5\t\t  6\t\t  7\t\t  8");
    }
    public static String convertNameToIcon(String name, char color){
        String[] blackIcons = {"♚","♛","♜","♝","♞","♟"};
        String[] whiteIcons = {"♔","♕","♖","♗","♘","♙"};
        HashMap<String, Integer> pieceToIndex = new HashMap<>();
        pieceToIndex.put("king", 0);
        pieceToIndex.put("queen", 1);
        pieceToIndex.put("rook", 2);
        pieceToIndex.put("bishop", 3);
        pieceToIndex.put("knight", 4);
        pieceToIndex.put("pawn", 5);
        int index = pieceToIndex.get(name);
        if(color == 'w'){
            return whiteIcons[index];
        }else{
            return blackIcons[index];
        }
    }
}
