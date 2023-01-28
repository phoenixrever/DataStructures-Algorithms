package com.phoenixhell.sparsearray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author チヨウ　カツヒ
 * @date 2023-01-19 22:13
 *
 * 稀疏数组
 * 当一个二维数组中大部分元素为0，或者为同一个值的数组时，可以用稀疏数组来保存该数组。
 * 常见场景 保存棋盘 和地图
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0 : 没有棋子   1： 黑子   2：白子
        int[][] chessArr1= new int[11][11];
        //其他int 值 默认未0
        //注意如果默认值不为0
        //for (int[] ints : chessArr1) {
        //    Arrays.fill(ints, 6);
        //}
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;



        //输出数组 打印棋盘
        printArray(chessArr1);

        // 将二维数组 转 稀疏数组
        // 1.先遍历二维数组，得到非零数据的个数  并且得到他们的坐标
        ArrayList<int[]> list = new ArrayList<>();
        int notZeroSum=0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j]!=0){
                    list.add(new int[]{i,j,chessArr1[i][j]});
                }
            }
        }
        notZeroSum=list.size();
        System.out.println("非零的个数为:"+notZeroSum);

        // 2.创建对应的稀疏数组  +1 是因为稀疏数组第一行记录了数组的行 列 非零值的个数
        int[][] sparseArr = new int[notZeroSum+1][3];
        // 3.给稀疏数第一行赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = notZeroSum;

        // 给稀疏数其他行赋值 从list 拿到非0的坐标和值存放在sparseArr中  稀疏数组 值从第二行开始
        for (int i = 0; i < list.size(); i++) {
            sparseArr[i+1][0]=list.get(i)[0];
            sparseArr[i+1][1]=list.get(i)[1];
            sparseArr[i+1][2]=list.get(i)[2];
        }
        System.out.println();
        System.out.println("赋完值的稀疏数组");
        printArray(sparseArr);

        // 将稀疏数组恢复成原始数组
        // 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2.读取稀疏数组的后几行数据（从第二行开始），并复制给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 3.输出恢复后的二维数组
        System.out.println("恢复后的二维数组~~");
        printArray(chessArr2);
    }


    // 打印棋盘（数组）的方法
    private static void printArray(int[][] chessArr1) {
        for (int[] row : chessArr1) {
            System.out.println(Arrays.toString(row));
        }
    }




}
