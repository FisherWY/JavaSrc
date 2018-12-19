package lesson10;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class homework2 {

    private static class User{
        private int id;
        private String name,gender;

        public User(int id, String name, String gender) {
            this.id = id;
            this.name = name;
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + gender;
        }
    }


    public static void main(String args[]){
        File file = new File("users.dat");

        //创建user对象
        List<User> users = new LinkedList<>();
        for (int i=0; i<10; i++){
            User u = new User(i,"a"+i,"g");
            users.add(u);
        }

        //写入文件
        try{
            FileWriter writer = new FileWriter(file);
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()){
                String s = iterator.next().toString();
                writer.write(s);
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        //读取文件并输出
        try {
            FileReader reader = new FileReader(file);
            char byt[] = new char[1024];
            int len = reader.read(byt);
            System.out.println(new String(byt, 0, len));
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
