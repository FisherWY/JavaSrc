package Chapter_14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: Fisher
 * @Date: 2018/11/2 8:17 PM
 */
public class UpdateStu implements Comparable<Object>{
    String name;
    long id;

    public UpdateStu(String name, long id){
        this.name = name;
        this.id = id;
    }

    public int compareTo(Object o){
        UpdateStu u = (UpdateStu)o;
        int result = id > u.id ? 1:(id==u.id ? 0:-1);
        return result;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static void main(String args[]){
        UpdateStu stu1 = new UpdateStu("李同学", 01011);
        UpdateStu stu2 = new UpdateStu("陈同学", 01021);
        UpdateStu stu3 = new UpdateStu("王同学", 01051);
        UpdateStu stu4 = new UpdateStu("马同学", 01012);

        TreeSet<UpdateStu> tree = new TreeSet<>();
        //HashSet tree = new HashSet();
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);
        tree.add(new UpdateStu("WZ", 12345));
        tree.add(new UpdateStu("WZ", 12345));

        //Set集合中的所有对象的迭代器
        Iterator<UpdateStu> it = tree.iterator();
        System.out.println("Sets集合中的所有元素:");
        while (it.hasNext()) {
            UpdateStu stu = (UpdateStu)it.next();
            System.out.println(stu.getId() + " " + stu.getName());
        }

        //截取排在stu2对象之前的对象
        it = tree.headSet(stu2).iterator();
        System.out.println("截取前面部分的集合:");
        while (it.hasNext()){
            UpdateStu stu = (UpdateStu)it.next();
            System.out.println(stu.getId() + " " + stu.getName());
        }

        //截取排在stu2与stu3之间的对象
        it = tree.subSet(stu2, stu3).iterator();
        System.out.println("截取中间部分的集合");
        while (it.hasNext()) {
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getId() + " " + stu.getName());
        }
    }
}
