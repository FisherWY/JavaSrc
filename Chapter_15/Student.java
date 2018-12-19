package Chapter_15;

import java.io.*;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class Student {
    public static void main(String args[]){
        //定义字符串数组
        String content[] = {"好久不见", "最近好吗", "常联系"};
        File file = new File("Word.txt");
        //FileWriter
        try{
            FileWriter fw = new FileWriter(file);
            //创建bufferedWriter对象
            BufferedWriter bufw = new BufferedWriter(fw);
            for (int k = 0; k < content.length; k++){
                bufw.write(content[k]);
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //FileReader
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            while ((s = bufr.readLine()) != null){
                i++;
                System.out.println("第" + i + "行: " + s);
            }
            bufr.close();
            fr.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
