package Chapter_14;

import java.util.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/2 9:39 PM
 */
public class MapText {
    public static void main(String args[]){
        Map<String, String> map = new HashMap<>();

        Emp emp0 = new Emp("351", "zhangsan");
        Emp emp1 = new Emp("512", "lisi");
        Emp emp2 = new Emp("853", "wangyi");
        Emp emp3 = new Emp("125", "zhaoliu");
        Emp emp4 = new Emp("341", "huangqi");

        map.put(emp4.getE_id(), emp4.getE_name());
        map.put(emp0.getE_id(), emp0.getE_name());
        map.put(emp1.getE_id(), emp1.getE_name());
        map.put(emp2.getE_id(), emp2.getE_name());
        map.put(emp3.getE_id(), emp3.getE_name());

        //获取Map集合中的key对象组合
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        System.out.println("HashMap类实现的Map集合，无序：");
        while (it.hasNext()){
            String str = (String)it.next();
            String name = (String)map.get(str);
            System.out.println(str + " " + name);
        }

        TreeMap<String, String> treemap = new TreeMap<>();
        treemap.putAll(map);
        Iterator<String> it1 = treemap.keySet().iterator();
        System.out.println("TreeMap类实现Map集合，键对象升序：");
        while (it1.hasNext()) {
            String str = (String)it1.next();
            String name = (String)treemap.get(str);
            System.out.println(str + " " + name);
        }
    }
}
