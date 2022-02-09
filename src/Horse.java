public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    String getSymbol() {
        return "H";
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                    chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                // all positions for horse
                int[][] pos = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int i = 0; i < pos.length; i++) {
                    if (pos[i][0] == toLine && pos[i][1] == toColumn)
                        return true;
                }
            }
        }
        return false;
    }


}
