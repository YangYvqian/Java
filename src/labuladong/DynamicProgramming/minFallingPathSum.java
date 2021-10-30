package labuladong.DynamicProgramming;
import java.util.Arrays;
// import java.util.stream.Stream;

public class minFallingPathSum {


    
// start 暴力解法
    public int minFallingPathS(int[][] matrix){
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        // 终点可能在最后一行的任意一列
        for(int j = 0; j < n; j++){
            res = Math.min(res, dp(matrix,n-1,j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j){
        if(i < 0 || j < 0 ||
           i >= matrix.length ||
           j >= matrix[0].length){
               return 99999;
           }

        //    base case
        if (i == 0){
            return matrix[i][j];
        }

        return matrix[i][j]+min(dp(matrix, i-1, j),
            dp(matrix, i-1, j-1),
            dp(matrix, i-1, j+1)
        );
    }

    public int min(int a, int b,  int c){
        return Math.min(a, Math.min(b, c));
    }

// end 暴力解法




// start 备忘录递归

    public int minFallingPathSumMemo(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 备忘录里的值初始化为 66666
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在 matrix[n-1] 的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dpMemo(matrix, n - 1, j));
        }
        return res;
    }

    // 备忘录
    int[][] memo;

    int dpMemo(int[][] matrix, int i, int j) {
        // 1、索引合法性检查
        if (i < 0 || j < 0 ||
            i >= matrix.length ||
            j >= matrix[0].length) {

            return 99999;
        }
        // 2、base case
        if (i == 0) {
            System.out.println(matrix[0][j]);
            return matrix[0][j];
            
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 进行状态转移
        memo[i][j] = matrix[i][j] + minMemo(
                dpMemo(matrix, i - 1, j), 
                dpMemo(matrix, i - 1, j - 1),
                dpMemo(matrix, i - 1, j + 1)
            );
            
        return memo[i][j];
    }

    int minMemo(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

//  end  备忘录递归





// start dp迭代

    public int minFallingPathSumIteration(int[][] matrix){
        int[][] dpArr = new int[matrix.length][matrix[0].length];
        for(int k = 0; k < matrix.length; k++)
        Arrays.fill(dpArr[k], 99999);
        // int res = Integer.MAX_VALUE;
        int n = matrix[0].length;

        // base case
        for (int j = 0; j < n; j++) {
            dpArr[0][j] = matrix[0][j];
        }
        if(matrix.length == 1){
        int minNum=Arrays.stream(dpArr[0]).min().getAsInt();
        return minNum;
        
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dpArr[i][j] = matrix[i][j] + minMemo(
                    
                    (i-1 >= 0 && j >= 0) ? dpArr[i-1][j] : 99999, 
                    (i-1 >= 0 && j-1 >= 0) ? dpArr[i-1][j-1] : 99999,
                    (i-1 >= 0 && j+1 < matrix[0].length) ? dpArr[i-1][j+1] : 99999
                );


            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.println(dpArr[i][j]);
            }
        }
        int minNum=Arrays.stream(dpArr[matrix.length-1]).min().getAsInt();
        return minNum ;
    }


// end  dp迭代




    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        // int[][] dpArr = new int[][]{{2,1,3}};
        minFallingPathSum mfg = new minFallingPathSum();
        // 暴力解法
        int res = mfg.minFallingPathS(matrix);
        System.out.println(res);

        // 备忘录解法
        int memo = mfg.minFallingPathSumMemo(matrix);
        System.out.println(memo);

        // dp迭代

        int dp = mfg.minFallingPathSumIteration(matrix);
        System.out.println(dp);


        
    }
    
}
