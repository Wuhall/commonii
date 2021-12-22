package com.springboot.algorithms;

import org.junit.Test;

/**
 * @author Wuhall
 * 算法入门
 * https://leetcode-cn.com/study-plan/algorithms/?progress=m8l0ja3
 */
public class LeetCode01 {
    /**
     * 轮转数组
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     */
    // 解法一 计算偏移量 k % length
    public int[] solution1(int[] nums, int k) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i ++) {
            arr[(i + k) % length] = nums[i];
        }
        return arr;
    }

    /**
     * 解法二：翻转数组, 其实就是一个栈
     * 第一次全量翻转 【7 6 5 4 3 2 1】
     * 第二次【0，k-1】翻转 【5 6 7 4 3 2 1】
     * 第三次【k，length】翻转 【5 6 7 1 2 3 4】
     */
    @Deprecated
    public int[] fanzhuan(int[] nums, int begin, int end) {
        int[] arr = new int[end - begin + 1];
        int index = 0;
        for (int i = begin; i <= end; i ++) {
            arr[index ++] = nums[i];
        }
        for (int i = end - begin; i > -1; i --) {
            nums[begin ++] = arr[i];
        }
        return nums;
    }

    public int[] fanzhuan1(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin ++;
            end --;
        }
        return nums;
    }

    public void printArr(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length - 1]);
    }

    /**
     * 递增数组的平方仍递增
     * [-4, -1, 0, 3, 10]
     */
    /**
     * 方法一：以0 为分割线，归并排序
     */

    /**
     * 比较两端，
     */
    public int[] solution2(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        int index = end;
        int[] arr = new int[nums.length];
        while (begin <= end) {
        }
        return nums;
    }




    @Test
    public void test1() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        nums = fanzhuan1(nums, 0, 6);
        printArr(nums);
    }

}
