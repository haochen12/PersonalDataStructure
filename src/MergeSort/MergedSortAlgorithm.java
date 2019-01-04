package MergeSort;

public class MergedSortAlgorithm {

    public static void main(String args[]) {
        int[] all = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        mergeSorted(all, 0, all.length - 1);

        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
    }

    static void mergeSorted(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSorted(list, start, middle);//前半部分
        mergeSorted(list, middle + 1, end);//后半部分

        mergeTwoList(list, start, middle, end);//将两个数组合并成有序的。
    }

    private static void mergeTwoList(int[] AList, int start, int middle, int end) {
        int pivotA = start;//数组AList 哨兵
        int pivotB = middle + 1;//数组BList 哨兵

        int index = 0;//遍历下整个数组的下标

        int[] temp = new int[end - start + 1];//临时存放数组的东西
        /**
         * 从两个数组中各取一个数，若是满足大小关系就放在temp数组中，对应的哨兵就往前走一步。否则往前走
         */
        while (pivotA <= middle && pivotB <= end) {
            if (AList[pivotA] <= AList[pivotB]) {
                temp[index++] = AList[pivotA++];
            } else {
                temp[index++] = AList[pivotB++];
            }
        }

        int remainStart = pivotA;//默认情况下，前半部分还有剩余的。
        int remainEnd = middle;

        if (pivotB <= end) {//若是后半部分又剩余，则赋值
            remainStart = pivotB;
            remainEnd = end;
        }

        for (int j = remainStart; j <= remainEnd; j++) {
            temp[index++] = AList[j];
        }

        for (int i = 0; i <= end - start; i++) {
            AList[start + i] = temp[i];
        }
    }
}
