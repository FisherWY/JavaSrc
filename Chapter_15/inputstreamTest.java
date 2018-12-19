package Chapter_15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: Fisher
 * @Date: 2018/11/16 9:07 PM
 */
public class inputstreamTest {
    public static void main(String args[]){
        File f = new File("word.txt");
        //fileoutput类对象
        try{
            byte[] b = "我有一只小毛驴".getBytes();
            FileOutputStream out = new FileOutputStream(f);
            out.write(b);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        //fileinput类对象
        try{
            FileInputStream in = new FileInputStream(f);
            byte[] byt = new byte[1024];
            int len = in.read(byt);
            //将文件中的信息输出
            System.out.println("文件中的信息是: " + new String(byt, 0, len));
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
