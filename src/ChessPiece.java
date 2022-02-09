abstract public class ChessPiece {
    String color;
    boolean check;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract String getColor();

    abstract String getSymbol();

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
