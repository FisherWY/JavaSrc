package lesson07;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 11:21 AM
 */
public class Food{
    private String no,name,type;

    Food(){
        no = "-1";
        name = "null";
        type = "null";
    }

    Food(String no,String name,String type){
        this.no = no;
        this.name = name;
        this.type = type;
    }

    String getNo(){
        return no;
    }

    String getName(){
        return name;
    }

    String getType(){
        return type;
    }
}
