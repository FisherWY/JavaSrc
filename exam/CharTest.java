package exam;

/**
 * @Author: Fisher
 * @Date: 2018/12/26 9:03 PM
 */
public class CharTest {
    public static void main(String args[]) {
        char ch[] = new char[100];
        int count = 0;
        System.out.println("随机产生的100个大写字母分别为:");
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 26);
            ch[i] = (char) (a + 65);
            System.out.print(ch[i] + "  ");
        }
        for (int i = 0; i < 100; i++) {
            if (ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
                count++;
            }
        }
        System.out.println("\n其中的元音字母有 " + count + " 个");
    }
}
