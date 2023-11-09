# Java Tic-Tac-Toe with Min-Max AI
## Overview
This project is a Java implementation of the classic Tic-Tac-Toe game. It features a simple text-based interface and an AI opponent that uses the Min-Max algorithm to determine its moves.

## Key Components
Board: Manages the game board, tracks player moves, and checks for win conditions.

BoardOperations: An interface that outlines the operations that can be performed on the game board.

MinMax: Contains the main method and the logic for the Min-Max algorithm, which the AI uses to play optimally.

Node: Represents a state of the game board along with a score used by the Min-Max algorithm.
## Gameplay
Players take turns marking spaces on a 3x3 grid, with one player as 'X' and the other as 'O' (the AI). The game continues until either a player wins by aligning three of their marks horizontally, vertically, or diagonally, or the board is filled, resulting in a draw.

## AI Strategy
The AI uses the Min-Max algorithm to evaluate all possible future moves and choose the one that maximizes its chances of winning while minimizing the player's chances. This makes the AI a challenging opponent.

## Usage
Run the MinMax class.
The game will prompt for the player's move (as row and column inputs).
After the player's move, the AI will calculate and make its move.
The game ends when there's a winner or a draw.
## Technologies Used
Java
## How to Run
Ensure you have Java installed on your machine. Compile and run the MinMax class to start the game.
