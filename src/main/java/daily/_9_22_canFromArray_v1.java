package daily;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]] <br></br> 输出：true <br></br> 解释：依次连接
 * [91]、[4,64] 和 [78] <br></br>
 */
public class _9_22_canFromArray_v1 {

    public boolean canFromArray(int[] arr, int[][] pieces) {
        boolean[] isUsed = new boolean[pieces.length];
        for (int i = 0; i < arr.length; i++) {
            int curHead = arr[i];
            //寻找符合的 head
            int nextIndex=getNextIndex(arr,i,pieces,isUsed);
            if (nextIndex==-1)
                return false;
            i=nextIndex-1;
        }
        return true;
    }

    private int getNextIndex(int[] arr, int curIndex, int[][] pieces, boolean[] isUsed) {
        if (curIndex >= arr.length) {
            return -1;
        }
        for (int j = 0; j < pieces.length; j++) {
            if (isUsed[j]) {
                continue;
            }
            boolean ok = true;
            for (int k = 0, o = curIndex; k < pieces[j].length; k++, o++) {
                if (arr[o] == pieces[j][k]) {
                    continue;
                }
                ok = false;
            }
            if (ok) {
                isUsed[j] = true;
                return curIndex+pieces[j].length;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        _9_22_canFromArray_v1 canFromArray = new _9_22_canFromArray_v1();
        int[] arr = {15,88};
        int[][] pieces = {{88},{15}};
        System.out.println(canFromArray.canFromArray(arr,pieces));
    }
}
