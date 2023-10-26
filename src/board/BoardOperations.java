package board;

public interface BoardOperations {

    boolean isValidMove(int row, int col);

    void placeMark(String mark, int row, int col);

    boolean isXWinner();

    boolean isOWinner();
 
    Board copyBoard();

    void printBoard();

    int getEmptyCellsCount();
    
    boolean isPlayerWinner(String player);
    
    public int countMarks(String mark);

    boolean playerWin();

    boolean isBoardFull();

    int getScore();

    int getLastMoveRow();

    int getLastMoveCol();

    String getMarkAt(int row, int col);
}

