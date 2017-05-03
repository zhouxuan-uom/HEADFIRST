package interview.algorithm.easy.answers;

import interview.algorithm.easy.questions.BattleshipsInABoard;

/**
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's,
 * empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN
 * (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 * Created by zhouxuan on 2016/12/30.
 */
public class BattleshipsInABoardAns implements BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'x' && board[i + 1][j] == '.' && board[i][j + 1] == '.') {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        BattleshipsInABoard battleshipsInABoard = new BattleshipsInABoardAns();
        System.out.println(battleshipsInABoard.countBattleships(board));
    }
}
