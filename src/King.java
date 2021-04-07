//король

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine>7||toLine<0)||(toColumn>7||toColumn<0) //checking moving inside chessboard
                ||hasObstacles(chessBoard, line, column, toLine, toColumn)) //checking on obstacles
            return false;

        //getting deltas
        int x = toColumn-column;
        int y = toLine-line;

        //check possibilities to move or attack
        if ((x==0&&Math.abs(y)==1)
            ||(y==0&&Math.abs(x)==1)
            ||(Math.abs(x)==1&&Math.abs(y)==1))
            return true;

        //default
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        ChessPiece[][] chessPieces = board.board;
        String enemyColor = color.equals("White") ? "Black" : "White";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessPieces[i][j]!=null&&chessPieces[i][j].getColor().equals(enemyColor)
                        &&chessPieces[i][j].canMoveToPosition(board, i, j, line, column))
                    return true;
            }
        }

        return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }

}
