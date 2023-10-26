package main;

import java.util.Scanner;

import board.Board;
import node.Node;

public class MinMax {
	public static void main(String[] args) {
	Board board = new Board();
	Scanner scanner = new Scanner(System.in);
	int depth = 9;

	System.out.println("Welcome to Tic-Tac-Toe! "+"\nPlayer X starts");

	while(true)
	{
		if (!board.isBoardFull() && !board.playerWin()) {
			System.out.println("Best next move is: ");
			Node bestMove = minMax(new Node(board), false, depth);
			bestMove.board.printBoard();
			System.out.print("Enter your move (row and column): \n");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			if (board.isValidMove(row, col)) {
				board.placeMark("X", row, col);
				board.printBoard();
			} else {
				System.out.println("Invalid move. Try again.");
				continue;
			}
		}

		if (board.isXWinner()) {
			System.out.println("You win!");
			break;
		} else if (board.isBoardFull()) {
			System.out.println("It's a draw.");
			break;
		}

		if (!board.isBoardFull() && !board.isOWinner() ) {
			Node initialNode = new Node(board);
			Node bestMove = minMax(initialNode, true, depth);
			board = bestMove.board;
			System.out.println("Computer's move: ");
			board.printBoard();

		}

		if (board.isOWinner()) {
			System.out.println("Computer wins!");
			break;
		}
	}scanner.close();
	}
	

	public static Node minMax(Node node, boolean isMaximizing, int depth) {
		if (node.board.playerWin() || node.board.isBoardFull() || depth == 0) {
			if (node.board.isXWinner()) {
			    node.score = -10 ;
			} else if (node.board.isOWinner()) {
			    node.score = 10;
			} else {
			    node.score = 0;
			}
			return node;
		}

	    if (isMaximizing) {
	        int bestScore = Integer.MIN_VALUE;
	        Node bestNode = new Node(node.board);
	        for (Node child : Node.getChildren(node, "O")) {
	            Node evalNode = minMax(child, false, depth - 1);
	            if (evalNode.score > bestScore) {
	                bestScore = evalNode.score;
	                bestNode = child;
	            }
	        }
	        bestNode.score = bestScore;
	        return bestNode;
	        
	    } else {
	        int bestScore = Integer.MAX_VALUE;
	        Node bestNode = new Node(node.board);
	        for (Node child : Node.getChildren(node, "X")) {
	            Node evalNode = minMax(child, true, depth - 1);
	            if (evalNode.score < bestScore) {
	                bestScore = evalNode.score;
	                bestNode = child;
	            }
	        }
	        bestNode.score = bestScore;
	        return bestNode;
	    }
	}
}