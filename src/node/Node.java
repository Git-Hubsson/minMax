package node;

import java.util.ArrayList;
import java.util.List;

import board.Board;

public class Node {
    public Board board;
    public int score;
    
    public Node(Board board) {
        this.board = board;
        this.score = 0;
    }

    public static List<Node> getChildren(Node parent, String player) {
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (parent.board.isValidMove(i, j)) {
                    Board childBoard = parent.board.copyBoard();
                    childBoard.placeMark(player, i, j);
                    children.add(new Node(childBoard));
                }
            }
        }
        return children;
    }

}