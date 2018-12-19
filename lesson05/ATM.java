package lesson05;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/10/8 11:03 AM
 */
public class ATM {
    public static class UnionCard {
        String password, type;
        double money, interest;
        Calendar date = Calendar.getInstance();

        UnionCard() {
            type = "UnionCard";
            password = "888888";
            money = 100.0;
            interest = 0.0035;
            date.set(2018, 5, 20);
        }

        UnionCard(String type, String password, double money, double interest, int year, int month, int day) {
            this.type = type;
            this.password = password;
            this.money = money;
            this.interest = interest;
            date.set(year, month, day);
        }

        public boolean login(String pass) {
            if (password.equals(pass)) {
                return true;
            } else {
                return false;
            }
        }

        public double getBalance() {
            return money;
        }

        public void save(double add) {
            Calendar today = Calendar.getInstance();
            int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
            date.setTime(new Date());
            money = money + money * interest * during;
            money += add;
            System.out.println("存钱成功，当前余额：" + money);
        }

        public void withdraw(double cut) {
            if (cut > money) {
                System.out.println("没有足够的余额！");
            } else {
                Calendar today = Calendar.getInstance();
                int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
                date.setTime(new Date());
                money = money + money * interest * during;
                money -= cut;
                System.out.println("取钱成功，当前余额：" + money);
            }
        }

        public void OnlinePay(double cut) {
            System.out.println("该卡不支持在线支付！");
        }

        public void WechatPay(double cut) {
            System.out.println("该卡不支持微信支付！");
        }
    }

    public static class ICBC extends UnionCard {
        ICBC(String type, String password, double money, double interest, int year, int month, int day) {
            super(type, password, money, interest, year, month, day);
        }

        public void OnlinePay(double cut) {
            Calendar today = Calendar.getInstance();
            int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
            date.setTime(new Date());
            money = money + money * interest * during;
            money -= cut;
            System.out.println("在线支付成功，支付金额：" + cut);
        }
    }

    public static class ABC extends UnionCard {
        ABC(String type, String password, double money, double interest, int year, int month, int day) {
            super(type, password, money, interest, year, month, day);
        }

        public void WechatPay(double cut) {
            Calendar today = Calendar.getInstance();
            int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
            date.setTime(new Date());
            money = money + money * interest * during;
            money -= cut;
            System.out.println("微信支付成功，支付金额：" + cut);
        }
    }

    public static class CGB extends UnionCard {
        CGB(String type, String password, double money, double interest, int year, int month, int day) {
            super(type, password, money, interest, year, month, day);
        }

        public void OnlinePay(double cut) {
            Calendar today = Calendar.getInstance();
            int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
            date.setTime(new Date());
            money = money + money * interest * during;
            money -= cut;
            System.out.println("在线支付成功，支付金额：" + cut);
        }

        public void WechatPay(double cut) {
            Calendar today = Calendar.getInstance();
            int during = (int) (today.getTimeInMillis() - date.getTimeInMillis()) / (1000 * 3600 * 24);
            date.setTime(new Date());
            money = money + money * interest * during;
            money -= cut;
            System.out.println("微信支付成功，支付金额：" + cut);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String[] CardType = {"UnionCard", "ICBC", "ABC", "CGB"};
        UnionCard[] cards = {new UnionCard(CardType[0], "123456", 100, 0.0035, 2018, 5, 20),
                new ICBC(CardType[1], "123456", 100, 0.0045, 2018, 5, 20),
                new ABC(CardType[2], "123456", 100, 0.0040, 2018, 5, 20),
                new CGB(CardType[3], "123456", 100, 0.0050, 2018, 5, 20)};
        String[] operator = {"(1)查询余额 (2)存钱 (3)提现",
                "(1)查询余额 (2)存钱 (3)提现 (4)在线支付",
                "(1)查询余额 (2)存钱 (3)提现 (5)微信支付",
                "(1)查询余额 (2)存钱 (3)提现 (4)在线支付 (5)微信支付"};
        while (true) {
            //确定银行卡类型
            System.out.println("欢迎使用万能ATM机！");
            System.out.println(" (1)" + CardType[0] + " (2)" + CardType[1] + " (3)" + CardType[2] + " (4)" + CardType[3]);
            System.out.println("选择你的银行卡类型:");
            int type = scan.nextInt() - 1;
            //密码认证
            int errortime = 0;
            while (errortime < 3) {
                System.out.println("请输入密码：");
                String pass = scan.next();
                if (cards[type].login(pass)) {
                    System.out.println("欢迎使用！");
                    break;
                } else {
                    System.out.println("密码错误！");
                    errortime++;
                    continue;
                }
            }
            if (errortime == 3) {
                System.out.println("密码错误3次，强行退卡！");
                continue;
            }
            //银行卡操作
            System.out.println("卡类型：" + CardType[type] + " 余额：" + cards[type].getBalance());
            do {
                System.out.println(operator[type]);
                System.out.println("请选择你的操作：");
                int myoperator = scan.nextInt();
                switch (myoperator) {
                    case 1:
                        System.out.println("余额：" + cards[type].getBalance());
                        break;
                    case 2:
                        System.out.println("要存多少钱呢：");
                        double money = scan.nextDouble();
                        cards[type].save(money);
                        break;
                    case 3:
                        System.out.println("要取多少钱呢：");
                        money = scan.nextDouble();
                        cards[type].withdraw(money);
                        break;
                    case 4:
                        System.out.println("输入支付金额：");
                        money = scan.nextDouble();
                        cards[type].OnlinePay(money);
                        break;
                    case 5:
                        System.out.println("输入支付金额：");
                        money = scan.nextDouble();
                        cards[type].WechatPay(money);
                        break;
                }
                System.out.println("退卡请输入exit，任意键继续操作:");
            } while (!scan.next().equals("exit"));
            System.out.println("退卡成功\n\n\n\n\n");
        }
    }
}
