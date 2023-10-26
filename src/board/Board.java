package board;

public class Board implements BoardOperations {
    private String[][] board;
    private int emptyCells;
    private int lastMoveRow = -1;
    private int lastMoveCol = -1;

    public Board() {
        board = new String[3][3];
        emptyCells = 9;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = " ";
            }
        }
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    
    @Override
    public int countMarks(String mark) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(mark)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean isXWinner() {
        return isPlayerWinner("X");
    }

    @Override
    public boolean isOWinner() {
        return isPlayerWinner("O");
    }

    @Override
	public boolean isPlayerWinner(String player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true; 
            }
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true; 
            }
        }
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true; 
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }


    @Override
    public Board copyBoard() {
        Board copy = new Board();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                copy.board[row][col] = board[row][col];
            }
        }
        copy.emptyCells = emptyCells;
        return copy;
    }
    
    @Override
    public int getEmptyCellsCount() {
        return emptyCells;
    }

    
    @Override
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
        System.out.println("");
    }
    
    
    @Override
    public boolean playerWin() {
        return isXWinner() || isOWinner();
    }
    
    @Override
    public boolean isBoardFull() {
        return emptyCells == 0;
    }
    
    @Override
    public int getScore() {
        if (isXWinner()) {
            return 10;
        } else if (isOWinner()) {
            return -10;
        } else {
            return 0;
        }
    }
    
    @Override
    public int getLastMoveRow() {
        return lastMoveRow;
    }
    
    @Override
    public int getLastMoveCol() {
        return lastMoveCol;
    }

    @Override
    public void placeMark(String mark, int row, int col) {
        board[row][col] = mark;
        emptyCells--;
        lastMoveRow = row;
        lastMoveCol = col;
    }
    
    @Override
    public String getMarkAt(int row, int col) {
        return board[row][col];
    }
}

