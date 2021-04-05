public class Queen extends ChessPiece {

    public Queen(String color) {
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
        if ((Math.abs(y)==Math.abs(x)&&x!=0)||(x==0&&y!=0||x!=0&&y==0)) return true;

        //default
        return false;
    }

    @Override
    String getSymbol() {
        return "Q";
    }


    protected boolean hasObstacles(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // linear steps
        if (line==toLine||column==toColumn)
            if (toLine > line) {
                for (int i = line+1; i <= toLine; i++) {
                    if (toColumn > column) {
                        for (int j = column+1; j <= toColumn; j++) {
                            if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                return true;          //return only on obstacles
                        }
                    } else if (toColumn < column) {
                        for (int j = column-1; j >= toColumn; j--) {
                            if (chessBoard.board[i][j] != null)
                                if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                    return true;          //return only on obstacles
                        }
                    } else {
                        if (chessBoard.board[i][column] != null)
                            if (impassableObstacle(chessBoard, i, column, toLine, toColumn))
                                return true;          //return only on obstacles
                    }
                }
            } else if (toLine < line) {
                for (int i = line-1; i >= toLine; i--) {
                    if (toColumn > column) {
                        for (int j = column+1; j <= toColumn; j++) {
                            if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                return true;          //return only on obstacles
                        }
                    } else if (toColumn < column) {
                        for (int j = column-1; j >= toColumn; j--) {
                            if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                return true;          //return only on obstacles
                        }
                    } else {
                        if (chessBoard.board[i][column] != null)
                            if (impassableObstacle(chessBoard, i, column, toLine, toColumn))
                                return true;          //return only on obstacles
                    }
                }
            }

        // diagonal steps
        if (Math.abs(toLine-line)==Math.abs(toColumn-column))
            if (toLine > line) {
                for (int i = line+1; i <= toLine; i++) {
                    if (toColumn > column) {
                        for (int j = column+1; j <= toColumn; j++) {
                            if (Math.abs(i-line) == Math.abs(j-column))
                                if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                    return true;          //return only on obstacles
                        }
                    } else if (toColumn < column) {
                        for (int j = column-1; j >= toColumn; j--) {
                            if (Math.abs(i-line) == Math.abs(j-column))
                                if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                    return true;          //return only on obstacles
                        }
                    }
                }
            } else if (toLine < line){
                for (int i = line-1; i >= toLine; i--) {
                    if (toColumn > column) {
                        for (int j = column+1; j <= toColumn; j++) {
                            if (Math.abs(i-line) == Math.abs(j-column))
                                if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                    return true;          //return only on obstacles
                        }
                    } else if (toColumn < column) {
                        for (int j = column-1; j >= toColumn; j--) {
                            if (Math.abs(i-line) == Math.abs(j-column))
                                if (impassableObstacle(chessBoard, i, j, toLine, toColumn))
                                    return true;          //return only on obstacles
                        }
                    }
                }
            }

        return false;
    }

    private boolean impassableObstacle (ChessBoard chessBoard, int i, int j, int toLine, int toColumn) {
        if (chessBoard.board[i][j] != null)      // any objects
            if (i != toLine || j != toColumn) {  //not destination cell
                return true;
            } else if (chessBoard.board[i][j].color.equals(color)) { // confederate object at destination cell
                return true;
            }
        //default
        return false;
    }


}
