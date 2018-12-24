package lesson13;

/**
 * @Author Fisher
 * @Date 2018/12/12 12:42
 **/
public class User {
    private String id = null;
    private String name = null;
    private String gender = null;
    private String address = null;
    private String aboutme = null;

    public User() {
    }

    public User(String id, String name, String gender, String address, String aboutme) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.aboutme = aboutme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String toString() {
        return id + " " + name + " " + gender + " " + address + " " + aboutme;
    }
}
