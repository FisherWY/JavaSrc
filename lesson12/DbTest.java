package lesson12;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Fisher
 * @Date 2018/12/12 11:29
 **/
public class DbTest {
    public static void main(String args[]){
        UserDao db = new UserDao();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("plz select operation: (1)add user (2)delete user (3)select user by id (4)select all the user (5)modify user (else)exit");
            int operate = Integer.parseInt(scanner.nextLine());
            switch (operate) {
                case 1:
                    System.out.println("input user id:");
                    String id = scanner.nextLine();
                    System.out.println("input user name:");
                    String name = scanner.nextLine();
                    System.out.println("input user gender:");
                    String gender = scanner.nextLine();
                    System.out.println("input user address:");
                    String address = scanner.nextLine();
                    System.out.println("input user about me:");
                    String aboutme = scanner.nextLine();
                    User u = new User(id, name, gender, address, aboutme);
                    if (db.addUser(u)){
                        System.out.println("insert success");
                    } else {
                        System.out.println("insert fail");
                    }
                    break;
                case 2:
                    System.out.println("input user id:");
                    String id1 = scanner.nextLine();
                    User u1 = new User(id1, "null", "null", "null", "null");
                    if (db.deleteUser(u1)) {
                        System.out.println("delete success");
                    } else {
                        System.out.println("delete fail");
                    }
                    break;
                case 3:
                    System.out.println("input user id:");
                    String id2 = scanner.nextLine();
                    User u2 = db.getUser(id2);
                    System.out.println("select user by id success");
                    System.out.println(u2.toString());
                    break;
                case 4:
                    List<User> list = db.getUsers();
                    Iterator<User> it = list.iterator();
                    System.out.println("select users success");
                    while (it.hasNext()) {
                        System.out.println(it.next().toString());
                    }
                    break;
                case 5:
                    System.out.println("input user id:");
                    String id3 = scanner.nextLine();
                    User u3 = db.getUser(id3);
                    System.out.println("find user information: ");
                    System.out.println(u3.toString());
                    System.out.println("input new information: ");
                    System.out.println("input user name:");
                    u3.setName(scanner.nextLine());
                    System.out.println("input user gender:");
                    u3.setGender(scanner.nextLine());
                    System.out.println("input user address:");
                    u3.setAddress(scanner.nextLine());
                    System.out.println("input user about me:");
                    u3.setAboutme(scanner.nextLine());
                    if (db.updateUser(u3)) {
                        System.out.println("update user success");
                    } else {
                        System.out.println("update fail");
                    }
                    break;
                default:
                    db.close();
                    System.out.println("exit");
                    running = false;
                    break;
            }
        }

    }
}
