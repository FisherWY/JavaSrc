package lesson10;

import java.io.*;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class homework1 {
    public static void main(String args[]){
        File source = new File("C:/test/Test.zip");
        File target1 = new File("C:/test/copy1.zip");
        File target2 = new File("C:/test/copy2.zip");

        //FileStream复制文件
        long startTime1 = System.currentTimeMillis();
        try{
            FileInputStream input = new FileInputStream(source);
            FileOutputStream output = new FileOutputStream(target1);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) > 0){
                output.write(buffer, 0, bytesRead);
            }
            input.close();
            output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        long stopTime1 = System.currentTimeMillis();
        System.out.println("不带buffer的复制时长: " + (stopTime1-startTime1) + "ms");

        //BufferFileStream复制文件
        long startTime2 = System.currentTimeMillis();
        try{
            FileInputStream input = new FileInputStream(source);
            FileOutputStream output = new FileOutputStream(target2);
            BufferedInputStream buffer_input = new BufferedInputStream(input);
            BufferedOutputStream buffer_output = new BufferedOutputStream(output);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = buffer_input.read(buffer)) > 0) {
                buffer_output.write(buffer, 0, bytesRead);
            }
            buffer_output.flush();
            input.close();
            output.close();
            buffer_input.close();
            buffer_output.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        long stopTime2 = System.currentTimeMillis();
        System.out.println("带buffer的复制时长: " + (stopTime2-startTime2) + "ms");
    }
}
