/**
 * Created by shaobin on 2017/6/3.
 */
public class Board {
	int[][] board;
	public Board (int n) {
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = (int) (Math.random() * 10) % 2;
			}
		}
	}

	public void display () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void life_game () {
		int[][] ans = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				ans[i][j] = new UnitCell(board,i,j).judge();
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ans[i][j];
			}
		}
	}
}
