package Chapter_9;

import java.text.DecimalFormat;

/**
 * @ Editor: Fisher
 * @ Date: 2018/9/5 下午8:47
 * @ Param:
 * @ Return:
 **/
public class DecimalFormatSimpleDemo {
    //使用实例化对象时设置格式化模式
    static public void SimgleFormat(String pattern, double value) {
        DecimalFormat myformat = new DecimalFormat(pattern);
        String output = myformat.format(value);     //将数组进行格式化
        System.out.println(value + " " + pattern + " " + output);
    }

    //使用 applyPattern()方法对数字进行格式化
    static public void UseApplyPatternMethodFormat(String pattern, double value) {
        DecimalFormat Myformat = new DecimalFormat();   //实例化 DecimalFormat对象
        Myformat.applyPattern(pattern);     //调用 applyPattern()方法设置格式化模版
        System.out.println(value + " " + pattern + " " + Myformat.format(value));
    }

    public static void main(String args[]) {
        SimgleFormat("###,###.###", 123456.789);        //调用静态 SimgleFormat()方法
        SimgleFormat("00000000.###kg", 123456.789);     //在数字后加上单位
        //按照格式模版格式化数字，不存在的位以0显示
        SimgleFormat("000000.000", 123.78);
        //调用静态 UseApplyPatternMethodFormat()方法
        UseApplyPatternMethodFormat("#.###%", 0.789);   //将数字转化为百分数形式
        //将小数点后格式化为两位
        UseApplyPatternMethodFormat("###.##", 123456.789);
        //将数字转化为千分数形式
        UseApplyPatternMethodFormat("0.00\u2030", 0.789);
    }
}
