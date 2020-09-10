import java.util.ArrayList;
import java.util.List;

public class DFS_substring {
    //递归枚举子序列模板
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<>();

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
            if (isVaild() && notVisited()) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        //如果选择当前元素
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        //回溯
        temp.remove(temp.size() - 1);
        //如果不选择当前元素
        dfs(cur + 1, nums);
    }

    // 第二种方式
    public void dfs2(int cur, int[] nums) {
        ans.add(new ArrayList<Integer>(temp));
        for (int i = cur; i < nums.length; i++) {
            // 如果有重复的数
//            if(i>cur && nums[i]==nums[i-1]){
//                continue;
//            }
            temp.add(nums[i]);
            dfs2(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    //判断子序列是否合法
    public boolean isVaild() {
        //根据题意判断
        return true;
    }

    //判断子序列是否重复
    public boolean notVisited() {
        //可以使用Set
        return true;
    }
}
