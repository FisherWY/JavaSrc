package lesson05;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 10:10 PM
 */
public class computer {
    private static class HDD {
        private String name;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    private static class Cpu extends HDD {

    }

    private static class MainBoard extends HDD {

    }

    private static class Motion extends HDD {

    }

    private static class GraphicCard extends HDD {

    }

    private static class Ram extends HDD {

    }

    private static class Power extends HDD {

    }

    private static class myDIYcomputer {
        private HDD hdd = new HDD();
        private Ram ram = new Ram();
        private GraphicCard graphicCard = new GraphicCard();
        private Cpu cpu = new Cpu();
        private MainBoard mainBoard = new MainBoard();
        private Motion motion = new Motion();
        private Power power = new Power();

        public Double getSumPrice() {
            return hdd.getPrice() + ram.getPrice() + graphicCard.getPrice() + cpu.getPrice() + mainBoard.getPrice() + motion.getPrice() + power.getPrice();
        }

        public void setMyDIYcomputer(String cputype, String ramtype, String graphiccard, String hddtype, String mainboardtype, String motiontype, String powertype,
                                     double CPU_price, double MainBoard_price, double Motion_price, double RAM_price, double HDD_price, double GraphiCard_price, double Power_price) {
            hdd.setName(hddtype);
            ram.setName(ramtype);
            graphicCard.setName(graphiccard);
            cpu.setName(cputype);
            mainBoard.setName(mainboardtype);
            motion.setName(motiontype);
            power.setName(powertype);

            hdd.setPrice(HDD_price);
            ram.setPrice(RAM_price);
            graphicCard.setPrice(GraphiCard_price);
            cpu.setPrice(CPU_price);
            mainBoard.setPrice(MainBoard_price);
            motion.setPrice(Motion_price);
            power.setPrice(Power_price);
        }

        public String getHDD() {
            return hdd.getName() + " $" + hdd.getPrice();
        }

        public String getRam() {
            return ram.getName() + " $" + ram.getPrice();
        }

        public String getGraphicCard() {
            return graphicCard.getName() + " $" + graphicCard.getPrice();
        }

        public String getCpu() {
            return cpu.getName() + " $" + cpu.getPrice();
        }

        public String getMainBoard() {
            return mainBoard.getName() + " $" + mainBoard.getPrice();
        }

        public String getMotion() {
            return motion.getName() + " $" + motion.getPrice();
        }

        public String getPower() {
            return power.getName() + " $" + power.getPrice();
        }
    }

    public static void main(String args[]) {
        String[] HDD_select = {"(1)Samsung SSD 860EVO 480G", "(2)Seagate HDD BarraCude 1T",
                "(3)Samsung SSD 860EVO 240G", "(4)Seagate HHD BarraCude 500GB"};
        double[] HDD_price = {600, 300, 300, 150};
        String[] RAM_select = {"(1)Kingston HyperX 8G DDR4 2400", "(2)USCORSAIR LPX 8G DDR4 2400",
                "(3)Kingston HyperX 4G DDR4 2400", "(4)USCORSAIR LPX 16G DDR4 2400"};
        double[] RAM_price = {800, 600, 400, 1200};
        String[] Graphic_select = {"(1)NVIDIA GeForce RTX 2080Ti", "(2)AMD RX 570",
                "(3)NVIDIA GeForce GTX 1080Ti", "(2)AMD RX 470"};
        double[] Graphic_price = {9000, 1600, 4000, 1000};
        String[] CPU_select = {"(1)Intel Core i7 7700k", "(2)AMD Ryzen R7 2700x",
                "(3)Intel Core i9 7980xe", "(4)AMD ThreadRipper2 2520wx"};
        double[] CPU_price = {2800, 2600, 12000, 13999};
        String[] Mainboard_select = {"(1)ASUS PRIME B250M-PLUS", "(2)MSI B450M MORTAR",
                "(3)ASUS PRIME Z370-A", "(4)MSI X470 GAMING PRO"};
        double[] Mainboard_price = {700, 1200, 1800, 2000};
        String[] Motion_select = {"(1)SAMSUNG 27 1800R", "(2)DELL 23.8 U2417H IPS",
                "(3)SAMSUNG 27 2k QHD 1800R", "(4)DELL 23.8 P2418D IPS"};
        double[] Motion_price = {1299.9, 1599.9, 2399, 1599};
        String[] Power_select = {"(1)红星1号炸弹", "(2)红星2号炸弹", "(3)红星3号炸弹", "(4)红星4号炸弹"};
        double[] Power_price = {99.9, 109.9, 119.9, 129.9};

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print(HDD_select[i] + " $" + HDD_price[i] + " ");
        }
        System.out.println("\nSelect HDD: ");
        int hdd_no = scan.nextInt() - 1;
        for (int i = 0; i < 4; i++) {
            System.out.print(RAM_select[i] + " $" + RAM_price[i] + " ");
        }
        //System.out.println(RAM_select[0] + " $" + RAM_price[0] + " " + RAM_select[1] + " $" + RAM_price[1]);
        System.out.println("\nSelect RAM: ");
        int ram_no = scan.nextInt() - 1;
        for (int i = 0; i < 4; i++) {
            System.out.print(Graphic_select[i] + " $" + Graphic_price[i] + " ");
        }
        //System.out.println(Graphic_select[0] + " $" + Graphic_price[0] + " " + Graphic_select[1] + " $" + Graphic_price[1]);
        System.out.println("\nSelect GraphicCard: ");
        int graphic_no = scan.nextInt() - 1;
        for (int i = 0; i < 4; i++) {
            System.out.print(CPU_select[i] + " $" + CPU_price[i] + " ");
        }
        //System.out.println(CPU_select[0] + " $" + CPU_price[0] + " " + CPU_select[1] + " $" + CPU_price[1]);
        System.out.println("\nSelect CPU: ");
        int cpu_no = scan.nextInt() - 1;
        for (int i = 0; i < 4; i++) {
            System.out.print(Mainboard_select[i] + " $" + Mainboard_price[i] + " ");
        }
        //System.out.println(Mainboard_select[0] + " $" + Mainboard_price[0] + " " + Mainboard_select[1] + " $" + Mainboard_price[1]);
        System.out.println("\nSelect Mainboard: ");
        int mainboard_no = scan.nextInt() - 1;
        for (int i = 0; i < 4; i++) {
            System.out.print(Motion_select[i] + " $" + Motion_price[i] + " ");
        }
        //System.out.println(Motion_select[0] + " $" + Motion_price[0] + " " + Motion_select[1] + " $" + Motion_price[1]);
        System.out.println("\nSelect Motion: ");
        int motion_no = scan.nextInt() - 1;

        for (int i = 0; i < 4; i++) {
            System.out.print(Power_select[i] + " $" + Power_price[i] + " ");
        }
        System.out.println("\nSelect Power");
        int power_no = scan.nextInt() - 1;

        myDIYcomputer computer = new myDIYcomputer();
        computer.setMyDIYcomputer(CPU_select[cpu_no], RAM_select[ram_no], Graphic_select[graphic_no], HDD_select[hdd_no], Mainboard_select[mainboard_no], Motion_select[motion_no], Power_select[power_no],
                CPU_price[cpu_no], Mainboard_price[mainboard_no], Motion_price[motion_no], RAM_price[ram_no], HDD_price[hdd_no], Graphic_price[graphic_no], Power_price[power_no]);

        System.out.println("配置单：\n" + computer.getCpu()
                + "\n" + computer.getGraphicCard()
                + "\n" + computer.getHDD()
                + "\n" + computer.getMainBoard()
                + "\n" + computer.getMotion()
                + "\n" + computer.getRam()
                + "\n" + computer.getPower());

        System.out.println("总价格：" + computer.getSumPrice());
    }
}