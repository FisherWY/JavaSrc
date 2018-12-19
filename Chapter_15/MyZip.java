package Chapter_15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class MyZip {
    private void zip(String zipFileName, File inputFile) throws Exception{
        FileOutputStream file = new FileOutputStream(zipFileName);
        ZipOutputStream out = new ZipOutputStream(file);
        zip1(out, inputFile, "");
        out.close();
    }

    private void zip1(ZipOutputStream out, File f, String base) throws Exception{
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            if (base.length() != 0) {
                out.putNextEntry(new ZipEntry(base + "/"));
            }
            for (int i=0; i<fl.length; i++){
                zip1(out, fl[i], base+fl[i]);
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            System.out.println(base);
            while ((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
        }
    }

    public static void main(String args[]){
        MyZip book = new MyZip();
        try {
            book.zip("D:/Test.zip", new File("D:/Qt.pdf"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
