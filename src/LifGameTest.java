import org.junit.Test;

/**
 * Created by shaobin on 2017/6/3.
 */
public class LifGameTest {
	@Test
	public void first_test () {
		int[][] board = {{1, 1, 0}, {1, 0, 0}, {0, 0, 0}};//new int[6][6];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void unit_test () {
		// read单元
		int[][] board = {{1, 1, 0}, {1, 0, 0}, {0, 0, 1}};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				UnitCell checkUnit = new UnitCell(board, i, j);
				System.out.println(i + ":" + j + ":");
				System.out.println(checkUnit.left_up + " " + checkUnit.up + " " + checkUnit.right_up);
				System.out.println(checkUnit.left + " " + checkUnit.self + " " + checkUnit.right);
				System.out.println(checkUnit.left_down + " " + checkUnit.down + " " + checkUnit.right_down);
			}
		}
	}

	@Test
	public void check_death_or_live () {
		int[][] board = {{1, 1, 0}, {1, 0, 0}, {0, 0, 1}};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				UnitCell checkUnit = new UnitCell(board, i, j);
				System.out.println(checkUnit.judge());
			}
		}
	}

	@Test
	public void extra_board () {
		int[][] board = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board[i][j] = (int) (Math.random() * 10) % 2;
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				UnitCell checkUnit = new UnitCell(board, i, j);
				System.out.print(checkUnit.judge() + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void create_board_class(){
		Board board = new Board(10);
		board.display();
	}

}
