import java.util.ArrayList;
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

    public static void getUserMove(ChessBoard board, char color) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("[%s] Your move: ", (color == 'w') ? "white" : "black");

        String input = sc.nextLine();
        if(input.matches("\\d{2} \\d{2}")){

            int currentRank = Character.getNumericValue(input.charAt(0));
            int currentFile = Character.getNumericValue(input.charAt(1));
            int nextRank = Character.getNumericValue(input.charAt(3));
            int nextFile = Character.getNumericValue(input.charAt(4));

            if(!ChessPosition.isValidPosition(currentFile,currentRank) || !ChessPosition.isValidPosition(nextFile,nextRank)){
                System.out.println("ERROR 404: Out Of Bound Input");
                getUserMove(board,color);
                return;
            }
            ChessPiece piece = board.pieces[Helpers.rankToRow(currentRank)][Helpers.fileToColumn(currentFile)];
            ChessPosition nxtPosition = new ChessPosition(nextFile, nextRank);
            if (piece != null) {
                if(piece.getColor() == color) {
                    ArrayList<ChessPosition> validMoves = piece.getAllPossibleMoves(board);
                    if (validMoves.contains(nxtPosition)) {
                        if (board.isThereAPiece(nextRank, nextFile)) {
                            ChessPiece capturedPiece = board.pieces[Helpers.rankToRow(nextRank)][Helpers.fileToColumn(nextFile)];
                            if (board.pieces[Helpers.rankToRow(nextRank)][Helpers.fileToColumn(nextFile)].color == 'w') {
                                board.capturedByBlack.add(capturedPiece);
                            } else {
                                board.capturedByWhite.add(capturedPiece);
                            }
                        }
                        board.pieces[Helpers.rankToRow(currentRank)][Helpers.fileToColumn(currentFile)] = null;
                        board.pieces[Helpers.rankToRow(nextRank)][Helpers.fileToColumn(nextFile)] = piece;
                        piece.position = nxtPosition;
                    } else {
                        System.out.println("The next move entered is not a valid move");
                        getUserMove(board, color);
                    }
                }
                else{
                    System.out.println("ERROR 404: Can't move someone's else piece");
                    getUserMove(board,color);
                }
            }
            else{
                System.out.println("ERROR 404: No Piece On Curr Position");
                getUserMove(board,color);
            }
        }
        else{
            System.out.println("ERROR 404: Kindly enter in a format like (\"12 34\")\nHere the starting 2 digits represent currentPos and the last 2 represent nextPos");
            getUserMove(board,color);
        }
    }
}
