package lesson09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Fisher
 * @Date: 2018/11/9 8:56 PM
 */
public class Regist_test {
    private JPanel panel1;
    private JPasswordField password_text;
    private JTextField name_text;
    private JTextField id_text;
    private JRadioButton boy;
    private JRadioButton girl;
    private JCheckBox football;
    private JCheckBox baseball;
    private JComboBox school_sys_box;
    private JList campus_list;
    private JTextArea intro;
    private JButton cancer;
    private JButton submit;
    private JLabel id;
    private JLabel name;
    private JLabel psw;
    private JLabel sex;
    private JLabel hobby;
    private JCheckBox basketball;
    private JLabel school_sys;
    private JLabel campus;
    private JLabel introduction;

    public Regist_test() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String[] sex = {"男", "女"};
//                String[] hobby = {"篮球", "足球", "棒球"};
//                String[] school_sys = {"本科","专科","研究生"};
//                String[] campus = {"五山","南海","大学城"};

                //性别
                String sex = "未知";
                if (boy.isSelected()) {
                    sex = "男";
                }
                if (girl.isSelected()) {
                    sex = "女";
                }

                //爱好
                String hobby = "";
                if (basketball.isSelected()) {
                    hobby += "篮球";
                }
                if (football.isSelected()) {
                    hobby += "足球";
                }
                if (baseball.isSelected()) {
                    hobby += "棒球";
                }

                //学制
                String school_sys = school_sys_box.getSelectedItem().toString();

                //校区
                String campus = "";
                if (campus_list.isSelectedIndex(0))
                    campus = "五山";
                if (campus_list.isSelectedIndex(1))
                    campus = "南海";
                if (campus_list.isSelectedIndex(2))
                    campus = "大学城";

                System.out.println("ID: " + id_text.getText());
                System.out.println("名字: " + name_text.getText());
                System.out.println("密码: " + password_text.getText());
                System.out.println("性别: " + sex);
                System.out.println("爱好: " + hobby);
                System.out.println("学制: " + school_sys);
                System.out.println("校区: " + campus);
                System.out.println("自我介绍: " + intro.getText());

                JOptionPane.showMessageDialog(null, id_text.getText() + name_text.getText() + "已注册");
            }
        });

        cancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_text.setText("");
                name_text.setText("");
                password_text.setText("");
                boy.setSelected(false);
                girl.setSelected(false);
                basketball.setSelected(false);
                baseball.setSelected(false);
                football.setSelected(false);
                campus_list.setSelectedIndex(0);
                school_sys_box.setSelectedIndex(0);
                campus_list.setSelectedIndex(0);
                intro.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Regist_test");
        frame.setContentPane(new Regist_test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
