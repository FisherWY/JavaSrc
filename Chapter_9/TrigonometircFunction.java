package Chapter_9;

/**
 * @ Editor: Fisher
 * @ Date: 2018/9/5 下午8:32
 * @ Param:
 * @ Return:
 **/
public class TrigonometircFunction {
    public static void main(String args[]) {
        //取 90度 的正弦
        System.out.println("90度的正弦值：" + Math.sin(Math.PI / 2));
        //取 0度 的余弦
        System.out.println("0度的正弦值：" + Math.cos(0));
        //取 60度 的正切
        System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
        //取2的平方根与2商的反正弦
        System.out.println("2的平方根与2商的反正弦：" + Math.asin(Math.sqrt(2) / 2));
        //取2的平方根与2商的反余弦
        System.out.println("2的平方根与2商的反余弦：" + Math.acos(Math.sqrt(2) / 2));
        //取1的反正切
        System.out.println("1的反正切值：" + Math.atan(1));
        //取 120度 的弧度值
        System.out.println("120度的弧度值：" + Math.toRadians(120.0));
        //取PI/2的角度
        System.out.println("PI/2的角度值：" + Math.toDegrees(Math.PI / 2));
    }
}


