package lesson08;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 10:37 AM
 */
public class TT<T> {
    private T id;

    TT(){
        System.out.println("TT无参构造函数");
    }
    TT(T id){
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
