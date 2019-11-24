package hkttty.niuke;

public class juZhen {
    int length;
    int rows;
    int cols;
    char[] matrix;
    char []str;


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length <= 0 || matrix.length <= 0
                || str == null || str.length <= 0) {
//            Integer.MIN_VALUE;

            return false;
        }
        this.length = str.length;
        this.rows = rows;
        this.cols = cols;
        this.matrix = matrix;
        this.str = str;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(helper(i,j,0,new boolean[matrix.length])){
                    return true;
                }
            }
        }

        return false;
    }

    boolean helper(int i, int j, int strIndex,boolean []visited) {
        if(strIndex==length){
            return true;
        }

        int mIndex = i * cols + j;
        if(i<0 || j<0 || i==rows || j==cols || matrix[mIndex] != str[strIndex] || visited[mIndex]==true){
            return false;
        }
        visited[mIndex] = true;
        boolean flag = helper(i+1,j,strIndex+1,visited) ||
                helper(i-1,j,strIndex+1,visited) ||
                helper(i,j+1,strIndex+1,visited) ||
                helper(i,j-1,strIndex+1,visited);
        if(!flag){
            visited[mIndex] = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int []a  = new int[]{213};
        char [] m = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        char []str = new char[]{'A','B','C','C','E','D'};
        boolean b = new juZhen().hasPath(m, 3, 4, str);
        System.out.println(b);
        //"ABCESFCSADEE",3,4,"ABCCED"
    }


}
