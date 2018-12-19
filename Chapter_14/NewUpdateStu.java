package Chapter_14;

import java.util.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/2 9:19 PM
 */
public class NewUpdateStu {
    public static void main(String args[]){
        Map<String, String> map = new HashMap<>();
        map.put("01", "李同学");
        map.put("02", "为同学");
        map.put("03", "帅哥");
        map.put("03", "老歌");

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();

        System.out.println("key集合中的元素：");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Collection<String> coll = map.values();
        it = coll.iterator();
        System.out.println("values集合中的元素：");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
