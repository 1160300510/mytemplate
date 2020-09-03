import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    List<List<String>> ans = new ArrayList<List<String>>();
    int N;
    char[][] board;

    // 返回所有符合题意的答案
    // 在n*n的棋盘上，任意两个皇后不在同一行，同一列，同一对角线
    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0);
        return ans;
    }

    public void dfs(int curRow) {
        if (curRow == N) {
            // 添加一种合法方案
            List<String> temp = new ArrayList<String>();
            for (char[] cur : board) {
                temp.add(String.valueOf(cur));
            }
            ans.add(temp);
            return;
        }
        for (int i = 0; i < N; i++) {
            int x = curRow;
            int y = i;
            if (isValid(x, y)) { // 检查合法化
                board[x][y] = 'Q';  // 合法就修改棋盘
                dfs(curRow + 1); // 继续搜索下一行
                board[x][y] = '.'; // 回溯
            }
        }
    }

    public boolean isValid(int x, int y) {
        // 检查行
        for (int i = 0; i < y; i++) {
            if (board[x][i] == 'Q') {
                return false;
            }
        }
        // 检查列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        // 检查对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
