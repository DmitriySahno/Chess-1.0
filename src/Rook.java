// ладья

public class Rook extends ChessPiece {

    public Rook(String color) {
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
        if ((x==0&&y!=0)||(x!=0&&y==0)) return true;

        //default
        return false;
    }

    @Override
    String getSymbol() {
        return "R";
    }


}
