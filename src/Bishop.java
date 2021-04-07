// слон

public class Bishop extends ChessPiece {

    public Bishop(String color) {
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
        if (Math.abs(y)==Math.abs(x)&&x!=0) return true;

        //default
        return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }

}
