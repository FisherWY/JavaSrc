package Chapter_17;

/**
 * @Author: Fisher
 * @Date: 2018/11/3 9:02 PM
 */
public class ShowEnum {
    enum Constants {
        CONSTANTS_A,
        CONSTANTS_B
    }

    public static void main(String args[]){
        System.out.println(Constants.values());
        for (int i=0; i<Constants.values().length; i++){
            System.out.println(Constants.values()[i] + "索引位置" + Constants.values()[i].ordinal());
        }
    }
}
