public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    String getSymbol() {
        return "R";
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;

            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;

            if (chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }

            return true;
        } else return false;
    }

    boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (board.board[i][j] != null) {
                        if (!board.board[i][j].getColor().equals(color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
}
