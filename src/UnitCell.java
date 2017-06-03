/**
 * Created by shaobin on 2017/6/3.
 */
public class UnitCell {
	int left_up = 0;
	int up = 0;
	int right_up = 0;
	int left = 0;
	int self = 0;
	int right = 0;
	int left_down = 0;
	int down = 0;
	int right_down = 0;

	public UnitCell (int[][] board, int i, int j) {
		if(i == 0) { // 首行位置
			left_up = 0;
			up = 0;
			right_up = 0;
			if (j == 0) {
				left = 0;
				left_down = 0;
				right = board[i][j + 1];
				right_down = board[i + 1][j + 1];
			}
			else if (j == board.length - 1) {
				left = board[i][j - 1];
				left_down = board[i + 1][j - 1];
				right = 0;
				right_down = 0;
			}
			else {
				left = board[i][j - 1];
				left_down = board[i + 1][j - 1];
				right = board[i][j + 1];
				right_down = board[i + 1][j + 1];
			}
			down = board[i + 1][j];
		}
		else if (i == board.length - 1) {// 尾行位置
			left_down = 0;
			down = 0;
			right_down = 0;
			if (j == 0) {
				left = 0;
				left_up = 0;
				right = board[i][j + 1];
				right_up = board[i - 1][j + 1];
			}
			else if (j == board.length - 1) {
				left = board[i][j - 1];
				left_up = board[i - 1][j - 1];
				right = 0;
				right_up = 0;
			}
			else {
				left = board[i][j - 1];
				left_up = board[i - 1][j - 1];
				right = board[i][j + 1];
				right_up = board[i - 1][j + 1];
			}
			up = board[i - 1][j];
		}
		else {
			if (j == 0) {
				left = 0;
				left_up = 0;
				left_down = 0;
				right = board[i][j + 1];
				right_up = board[i - 1][j + 1];
				right_down = board[i + 1][j + 1];
			}
			else if (j == board.length - 1) {
				left = board[i][j - 1];
				left_up = board[i - 1][j - 1];
				left_down = board[i + 1][j - 1];
				right = 0;
				right_up = 0;
				right_down = 0;
			}
			else {
				left = board[i][j - 1];
				left_up = board[i - 1][j - 1];
				left_down = board[i + 1][j - 1];
				right = board[i][j + 1];
				right_up = board[i - 1][j + 1];
				right_down = board[i + 1][j + 1];
			}
			up = board[i - 1][j];
			down = board[i + 1][j];
		}
		self = board[i][j];
	}

	public int judge () {
		int count = 0;
		if(left_up == 1) count ++;
		if(up == 1) count ++;
		if(right_up == 1) count ++;
		if(left == 1) count ++;
		if(right == 1) count ++;
		if(left_down == 1) count ++;
		if(down == 1) count ++;
		if(right_down == 1) count ++;
		if(count == 3){
			self = 1;
		}
		else if(count == 2){
			self = self;
		}
		else{
			self =0;
		}
		return self;
	}

}
