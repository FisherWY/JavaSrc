package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Fisher
 * @Date 2019/7/12 21:20
 **/


public class solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int[] num = new int[sum];
        int i=0,j=0,pos=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[pos] = nums1[i];
                i++;
            } else {
                num[pos] = nums2[j];
                j++;
            }
            pos++;
        }
        while (i<nums1.length) {
            num[pos] = nums1[i];
            i++;
            pos++;
        }
        while (j<nums2.length) {
            num[pos] = nums2[j];
            j++;
            pos++;
        }
        if (sum%2 == 0) {
            return (double)(num[sum/2] + num[sum/2-1])/2;
        } else {
            return num[sum/2];
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
