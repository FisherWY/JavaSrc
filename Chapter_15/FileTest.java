package Chapter_15;

import java.io.File;

/**
 * @Author: Fisher
 * @Date: 2018/11/14 11:38 AM
 */
public class FileTest {
    public static void main(String args[]){
        File f = new File("word.txt");
        if (f.exists()) {
            f.delete();
            System.out.println("文件已删除");
        } else {
            try {
                f.createNewFile();
                System.out.println("文件已创建");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
