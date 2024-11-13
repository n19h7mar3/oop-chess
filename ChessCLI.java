import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChessCLI {
    public static void renderBoard(ChessBoard board){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        display(board);
        System.out.print("\nPieces Captured By White: ");
        System.out.println(board.capturedByWhite.toString());
        System.out.print("Pieces Captured By Black: ");
        System.out.println(board.capturedByBlack.toString());
    }
    public static void getUserMove(ChessBoard board, char color){
        Scanner sc = new Scanner(System.in);
        if(color == 'w'){
            System.out.print("Enter white's move: ");
        }else{
            System.out.print("Enter black's move: ");
        }
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
                    if (ifContains(validMoves,nxtPosition)) {
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

    public static void display(ChessBoard board){
        System.out.println("  +-------+-------+-------+-------+-------+-------+-------+-------+");


        for (int i = 0; i < 8; i++) {
            System.out.print((8-i) + " |");

            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.pieces[i][j];
                if (piece==null) {
                    System.out.print("       ");
                } else {
                    System.out.print("   " + convertNameToIcon(piece.pieceType, piece.color)+ "   ");
                }
                System.out.print("|");
            }

            System.out.println("\n  +-------+-------+-------+-------+-------+-------+-------+-------+");

        }

        System.out.println("      1       2       3       4       5       6       7       8");

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
    public static boolean ifContains(ArrayList<ChessPosition> moves, ChessPosition nxtPosition){
        for (ChessPosition move : moves) {
            if (move.getRank() == nxtPosition.getRank() && move.getFile() == nxtPosition.getFile()) {
                return true;
            }
        }
        return false;
    }
}
