public class Helpers {
    public static char invertColor(char color) {
        return ((color == 'w') ? 'b' : 'w');
    }
    public static int rankToRow(int rank){
        return rank-1;
    }
    public static int fileToColumn(int file){
        return file-1;
    }
}
