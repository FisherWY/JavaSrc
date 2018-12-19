package lesson02;

/**
 * @Author: Fisher
 * @Date: 2018/9/12 下午2:19
 */
public class TestArr {
    final static int length = 10;

    public static void Rotate(int Arr[], int start, int end) {
        int temp;
        for (int i = 0; i <= (end - start) / 2; i++) {
            temp = Arr[start + i];
            Arr[start + i] = Arr[end - i];
            Arr[end - i] = temp;
        }
    }

    public static void move(int Arr[], int pos) {
        Rotate(Arr, 0, pos - 1);
        Rotate(Arr, pos, length - 1);
        Rotate(Arr, 0, length - 1);
    }

    public static void main(String args[]) {
        int[] Arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        move(Arr, 1);
        for (int x : Arr) {
            System.out.print(x + " ");
        }
    }
}
