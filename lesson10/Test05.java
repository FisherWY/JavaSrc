package lesson10;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用异常捕获机制完成下述读取操作，并在finally中有关闭RandomAccessFile操作。
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后按照员工入职从晚到早的顺序依次输出员工信息。
 * 
 * 该文件560字节，每56个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为short,长度为2个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为long，长度为8个字节
 * 格式可参考当前包中emp.jpg图
 * @author Xiloer
 *
 */
public class Test05 {

    private static class Employee{
        private String name,gender;
        short age;
        int salary;
        long hiredate;

        public Employee(String name, String gender, short age, int salary, long hiredate) {
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.salary = salary;
            this.hiredate = hiredate;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + gender + " " + hiredate + " " + salary;
        }
    }

    public static void main(String args[]){
        File file = new File("C:/Users/Fisher/IdeaProjects/Java/src/lesson10/emp.dat");
        List<Employee> list = new LinkedList<Employee>();

        try{
            FileInputStream input = new FileInputStream(file);
            byte cache[] = new byte[56];
            while (input.read(cache) > 0){
                //名字转码
                String name = new String(cache,0,32);
                //年龄转码
                byte cache_age[] = new byte[2];
                System.arraycopy(cache,32,cache_age,0,2);
                short age = byteProcess.byteToShort(cache_age);
                //性别转码
                String gender = new String(cache,34,10);
                //薪水转码
                byte cache_salary[] = new byte[4];
                System.arraycopy(cache,44,cache_salary,0,4);
                int salary = byteProcess.ByteArray2Int(cache_salary);
                //出生日期转码
                byte cache_hiredate[] = new byte[8];
                System.arraycopy(cache,48,cache_hiredate,0,8);
                long hiredate = byteProcess.bytesToLong(cache_hiredate);

                Employee employee = new Employee(name,gender,age,salary,hiredate);
                list.add(employee);
            }
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

}
