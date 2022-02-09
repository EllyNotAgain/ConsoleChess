public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    String getSymbol() {
        return "P";
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) { // position in board
            if (column == toColumn) { // we aren't going to eat piece
                int dir;
                int start;

                if (color.equals("White")) {    // white piece
                    dir = 1;
                    start = 1;
                } else {                        // black piece
                    dir = -1;
                    start = 6;
                }

                if (line + dir == toLine) {     //check direction
                    return chessBoard.board[toLine][toColumn] == null;
                }

                if (line == start && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null; // check that positions is null
                }

            } else { // we are going to eat piece

                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && // check that piece another color
                        chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }
}
