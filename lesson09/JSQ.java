package lesson09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Fisher
 * @Date: 2018/11/10 9:58 AM
 */
public class JSQ {
    //按钮
    private JPanel panel1;
    private JTextField display;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton add;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton cut;
    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num0;
    private JButton point;
    private JButton equal;
    private JButton division;
    private JButton multiple;
    private JButton clear;

    //计算机初始化参数
    static Double sum = 0d;
    static Double cache = 0d;
    //前面是否有操作符
    boolean haveOperator = false;
    String lastOperator = "";
    //前面是否有小数点
    boolean havePoint = false;
    Integer digit = 1;

    //输出格式化
    DecimalFormat df = new DecimalFormat("#.###");

    JSQ() {
        display.setText("");
        //按钮"+"监听事件
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
            }
        });
        //按钮"-"监听事件
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cut();
            }
        });
        //按钮"*"监听事件
        multiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Multiple();
            }
        });
        //按钮"/"监听事件
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Division();
            }
        });
        //按钮"="监听事件
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equals();
            }
        });
        //按钮"."监听事件
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPoint();
            }
        });

        //监听0-9按钮点击事件
        num0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(0d);
            }
        });
        num1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(1d);
            }
        });
        num2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(2d);
            }
        });
        num3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(3d);
            }
        });
        num4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(4d);
            }
        });
        num5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(5d);
            }
        });
        num6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(6d);
            }
        });
        num7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(7d);
            }
        });
        num8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(8d);
            }
        });
        num9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(9d);
            }
        });
        //全清按钮监听事件
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
            }
        });
    }

    private void Clear() {
        sum = 0d;
        cache = 0d;
        haveOperator = false;
        havePoint = false;
        digit = 1;
        display.setText("Reseted");
    }

    private void Add() {
        if (haveOperator) {
            operate();
        }
        haveOperator = true;
        lastOperator = "+";
        havePoint = false;
        digit = 1;
        cache = 0d;
        display.setText("+");
    }

    private void Cut() {
        if (haveOperator) {
            operate();
        }
        haveOperator = true;
        lastOperator = "-";
        havePoint = false;
        digit = 1;
        cache = 0d;
        display.setText("-");
    }

    private void Multiple() {
        if (haveOperator) {
            operate();
        }
        haveOperator = true;
        lastOperator = "*";
        havePoint = false;
        digit = 1;
        cache = 0d;
        display.setText("*");
    }

    private void Division() {
        if (haveOperator) {
            operate();
        }
        haveOperator = true;
        lastOperator = "/";
        havePoint = false;
        digit = 1;
        cache = 0d;
        display.setText("/");
    }

    private void Equals() {
        operate();
//        System.out.println("sum: " + sum);
//        System.out.println("cache: " + cache);
    }

    private void AddPoint() {
        if (havePoint) {
            return;
        }
        havePoint = true;
        if (!haveOperator) {
            display.setText(df.format(sum));
        } else {
            display.setText(df.format(cache));
        }
    }

    private void operate() {
        switch (lastOperator) {
            case "+":
                sum += cache;
                break;
            case "-":
                sum -= cache;
                break;
            case "/":
                sum /= cache;
                break;
            case "*":
                sum *= cache;
                break;
        }
        haveOperator = false;
        havePoint = false;
        digit = 1;
        cache = 0d;
        display.setText(df.format(sum));
    }

    private void setNum(Double num) {
        if (!haveOperator) {
            if (havePoint) {
                sum = sum + num / (10 * digit);
                digit *= 10;
            } else {
                sum = sum * 10 + num;
            }
            display.setText(sum.toString());
        } else {
            if (havePoint) {
                cache = cache + cache / (10 * digit);
                digit *= 10;
            } else {
                cache = cache * 10 + num;
            }
            display.setText(cache.toString());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JSQ");
        frame.setContentPane(new JSQ().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
