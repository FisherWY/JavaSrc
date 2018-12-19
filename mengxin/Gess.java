package mengxin;

/**
 * @ Editor: Fisher
 * @ Date: 2018/8/18 下午5:28
 * @ Param:
 * @ Return:
 **/

class Gess {
    private String name;

    public String getName() {
        int id = 0;
        setName("Java");
        return id + this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Gess getBook() {
        return this;
    }
}

class MyGess {
    private String name = "HHHHHHH";

    public String Myname() {
        return name;
    }
}