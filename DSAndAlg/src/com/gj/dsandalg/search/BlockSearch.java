package com.gj.dsandalg.search;

/**
 * 分块查找适用的场景比较少，但是大体上是将一组数据进行分块，先确定需要查找的数据位于哪一块，然后再对应的数据块内进行查找；
 * 然而这样的数据需要有以下的特点才可以使用分块查找：
 * <p>
 * 前一块的数据最大值要小于后一块的数据最小值；
 * 分块的个数一般服从于总数居的长度开根号；
 */

public class BlockSearch {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};
        //创建三个块的对象
        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);
        //定义数组用来管理三个块的对象（索引表）
        Block[] blockArr = {b1, b2, b3};
        //定义一个变量用来记录要查找的元素
        int number = 37;

        //调用方法
        int index = getIndex(blockArr, arr, number);
        //打印一下
        System.out.println(index);
    }

    private static int getIndex(Block[] blockArr, int[] arr, int number) {
        //调用findIndexBlock
        int indexBlock = findIndexBlock(blockArr, number);
        if (indexBlock == -1) {
            //表示number不在数组当中
            return -1;
        }
        //获取这一块的起始索引和结束索引
        int startIndex = blockArr[indexBlock].getStartIndex();
        int endIndex = blockArr[indexBlock].getEndIndex();
        //遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    //定义一个方法，用来确定number在哪一块当中
    public static int findIndexBlock(Block[] blockArr, int number) { //100
        for (int i = 0; i < blockArr.length; i++) {
            if (number <= blockArr[i].getMax()) {
                return i;
            }
        }
        return -1;
    }
}


//创建Block对象
class Block {
    private int max;//最大值
    private int startIndex;//起始索引
    private int endIndex;//结束索引

    public Block() {
    }

    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String toString() {
        return "Block{max = " + max + ", startIndex = " + startIndex + ", endIndex = " + endIndex + "}";
    }
}