package Chapter_14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: Fisher
 * @Date: 2018/11/2 4:42 PM
 */
public class Muster {
    public static void main(String args[]){
        Collection<String> list = new ArrayList<>();        //实例化集合类对象
        ((ArrayList<String>) list).add("a");                //向集合添加数据
        ((ArrayList<String>) list).add("b");
        ((ArrayList<String>) list).add("c");
        Iterator<String> it = list.iterator();              //创建迭代器
        while (it.hasNext()){                               //判断是否有下一个元素
            String str = (String)it.next();                 //获取集合中的元素
            System.out.println(str);
        }
    }
}
