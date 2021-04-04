// конь

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //checking moving inside chessboard
        if ((toLine>7||toLine<0)||(toColumn>7||toColumn<0)) return false;

        if (chessBoard.board[toLine][toColumn]!=null
                &&chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            return false;
        }

        //getting deltas
        int x = toColumn-column;
        int y = toLine-line;


        if ((Math.abs(x)==1&&Math.abs(y)==2)
            ||(Math.abs(y)==1&&Math.abs(x)==2))
            return true;

        //default
        return false;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
