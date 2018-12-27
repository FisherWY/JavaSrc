package exam;

import java.io.*;

/**
 * @Author: Fisher
 * @Date: 2018/12/25 8:34 PM
 */
public class write {
    public static void main(String args[]) {
        File f = new File("word.txt");
//        FileOutputStream outputStream = null;
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
//             outputStream = new FileOutputStream(f);
            writer = new FileWriter(f,true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("sdasda");
            bufferedWriter.newLine();
            bufferedWriter.write("asdasdadaaaaaaaa");
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("没有找到文件");
            e.printStackTrace();
        }


    }
}
