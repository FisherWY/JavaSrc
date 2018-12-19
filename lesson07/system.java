package lesson07;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/10/31 11:20 AM
 */
public class system {
    Food food = new Food();
    String errmsg = "该食物不存在这种做法";

    //显示菜单
    public void showmenu(){
        System.out.print("请选择食材：");
        System.out.println("0:苹果 1:橙子 2:牛肉 3:猪肉 4:鲈鱼 5:鳟鱼 6:西红柿 7:西兰花");
    }

    //选择食物
    public void selectfood(int no){
        switch (no){
            case 0: food = (Food)new apple();
                    break;
            case 1: food = (Food)new orange();
                    break;
            case 2: food = (Food)new beef();
                    break;
            case 3: food = (Food)new pork();
                    break;
            case 4: food = (Food)new luyu();
                    break;
            case 5: food = (Food)new zunyu();
                    break;
            case 6: food = (Food)new tomato();
                    break;
            case 7: food = (Food)new broccoil();
                    break;
            default: System.out.println("输入错误，不存在那种食物");
        }
    }

    //显示所有的制作方式
    public void makemethod(){
        System.out.print("请选择制作方式：");
        System.out.println("0:生吃 1:沙拉 2:烤 3:炒 4:炖 5:煎 6:蒸 7:汤");
    }

    //显示所选食物有的制作方式
    public void makemethod1(){
        if (food instanceof showcooking) {
            ((showcooking) food).showcooking();
        } else {
            System.out.println(errmsg);
        }
    }

    //选择制作方式
    public void selectmethod(int no){
        switch (no){
            case 0: eat();
                    break;
            case 1: salad();
                    break;
            case 2: bbq();
                    break;
            case 3: fry();
                    break;
            case 4: stew();
                    break;
            case 5: fired();
                    break;
            case 6: steam();
                    break;
            case 7: soup();
                    break;
            default: System.out.println("输入错误，不存在那种做法");
        }
    }

    //生吃
    public void eat(){
        if (food instanceof eat){
            ((eat) food).eat();
        } else {
            System.out.println(errmsg);
        }
    }

    //沙拉
    public void salad(){
        if (food instanceof salad){
            ((salad) food).salad();
        } else {
            System.out.println(errmsg);
        }
    }

    //烤
    public void bbq(){
        if (food instanceof bbq){
            ((bbq) food).bbq();
        } else {
            System.out.println(errmsg);
        }
    }

    //炒
    public void fry(){
        if (food instanceof fry){
            ((fry) food).fry();
        } else {
            System.out.println(errmsg);
        }
    }

    //炖
    public void stew(){
        if (food instanceof stew){
            ((stew) food).stew();
        } else {
            System.out.println(errmsg);
        }
    }

    //煎
    public void fired(){
        if (food instanceof fired){
            ((fired) food).fired();
        } else {
            System.out.println(errmsg);
        }
    }

    //蒸
    public void steam(){
        if (food instanceof steam){
            ((steam) food).steam();
        } else {
            System.out.println(errmsg);
        }
    }

    //汤
    public void soup(){
        if (food instanceof soup){
            ((soup) food).soup();
        } else {
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        system sys = new system();
        int select;
        sys.showmenu();
        select = scan.nextInt();
        sys.selectfood(select);
        sys.makemethod();
        sys.makemethod1();
        select = scan.nextInt();
        sys.selectmethod(select);
    }
}
