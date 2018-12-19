package lesson08;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 10:50 AM
 */
public class User {
    private String id,name,gender;

    public User(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public User() {
        this.id = "0";
        this.name = "null";
        this.gender = "null";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return (id + " " + name + " " + gender);
    }
}
