package lesson08;

import java.util.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 11:38 AM
 */
public class TestUser_User {
    public static void main(String args[]){
        String[] genders = {"男", "女"};

        ArrayList<User> list = new ArrayList<>();
        Set<User> set = new HashSet<>();
        Map<String, User> map = new HashMap();

        Random r = new Random();
        for (int i=0; i<50; i++){
            User u = new User("emp" + r.nextInt(50),"emp" + i,genders[r.nextInt(2)]);
            list.add(u);
            set.add(u);
            map.put(u.getId(),u);
        }

        System.out.println("list中的学生信息的数量:" + list.size());
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        System.out.println("\nset中的学生信息的数量:" + set.size());
        Iterator<User> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        System.out.println("\nmap中的学生信息的数量:" + map.size());
        Iterator<String> it1 = map.keySet().iterator();
        while (it1.hasNext()){
            User u = map.get(it1.next());
            System.out.println(u.toString());
        }
    }
}
