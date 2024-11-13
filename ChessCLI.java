import java.util.Scanner;

public class ChessCLI {

    private static final String[] chessIcons = {
        "♚", "♛", "♜", "♝", "♞", "♟",
        "♔", "♕", "♖", "♗", "♘", "♙"
    };

    public static void renderBoard(ChessBoard board) {
        // Clear screen by pushing everything past the scroll view
        for (int i = 0; i < 25; i++) System.out.println();

        displayBoard(board);

        System.out.print("\nPieces Captured By White: ");
        System.out.println(board.capturedByWhite.toString());
        System.out.print("Pieces Captured By Black: ");
        System.out.println(board.capturedByBlack.toString());
    }

    private static void displayBoard(ChessBoard board) {
        for (int i = 0; i < 8; i++) {
            System.out.println("\n  +-------+-------+-------+-------+-------+-------+-------+-------+");
            System.out.print((8 - i) + " |");

            for (int j = 0; j < 8; j++) {

                if (board.pieces[i][j] == null) {
                    System.out.print("       |");
                    continue;
                }

                System.out.printf("   %s   |", getPieceIcon(board.pieces[i][j].pieceType, board.pieces[i][j].color));
            }
        }

        System.out.println("\n  +-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("      a       b       c       d       e       f       g       h");
    }

    private static String getPieceIcon(String type, char color) {
        int index;
        switch (type) {
            case "king":   index = 0; break;
            case "queen":  index = 1; break;
            case "rook":   index = 2; break;
            case "bishop": index = 3; break;
            case "knight": index = 4; break;
            case "pawn":   index = 5; break;

            default:
                throw new IllegalArgumentException("ChessCLI: Invalid pieceType specified.");
        }

        if (color == 'b') index += 6;
        return chessIcons[index];
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
}
