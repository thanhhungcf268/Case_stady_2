package CaseStudy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

public class Admin implements Serializable {
    public static double total = 0;
    private List<SoftDrink> list = new ArrayList<>();
    private List<Staff> lists = new ArrayList<>();

    public Admin() {
        System.out.println(" Hello Admin !!");
        readFile();
    }

    public List<SoftDrink> getList() {
        return list;
    }

    public void setList(List<SoftDrink> list) {
        this.list = list;
    }

    public void setTotal() {
        Map<String, Integer> map = new HashMap<>();
        try {
            File f = new File("D:\\total.csv");
            if (!f.exists()||f.length()==0) {
                System.out.println(" Chưa có giao dịch nào được thực hiện !");
                return;
            }
            FileInputStream fis = new FileInputStream("D:\\total.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (Map<String, Integer>) ois.readObject();
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                total += m.getValue();
                System.out.println(m.getKey() + " " + m.getValue());
            }
            System.out.println("tổng là : " + total);
            double goc = Math.floor(total / 1.1);
            double lai = total - goc;
            System.out.println(" tiền lãi là  : " + lai);
            ois.close();
        } catch (Exception e) {
            System.err.println(BlockStatic.ERROR_FILE_READ);
        }
    }

    private int[] getInformation() {
        System.out.println(" Enter Price ");
        int price = BlockStatic.sc.nextInt();
        System.out.println(" Number of warehouses ");
        int count = BlockStatic.sc.nextInt();
        return new int[]{price, count};
    }

    public void addCOca(int choice) {
        SoftDrink s = getSoftDrink(choice);
        int[] array = getInformation();
        s.setPrice(array[0]);
        s.setCount(array[1]);
        for (SoftDrink l : list) {
            if (l instanceof Coca) {
                l.setPrice(array[0]);
                int count = l.getCount() + array[1];
                l.setCount(count);
                break;
            }
        }
    }

    public void addPepsi(int choice) {
        SoftDrink s = getSoftDrink(choice);
        int[] array = getInformation();
        s.setPrice(array[0]);
        s.setCount(array[1]);
        for (SoftDrink l : list) {
            if (l instanceof Pepsi) {
                l.setPrice(array[0]);
                int count = l.getCount() + array[1];
                l.setCount(count);
                break;
            }
        }
    }

    public void addOrange(int choice) {
        SoftDrink s = getSoftDrink(choice);
        int[] array = getInformation();
        s.setPrice(array[0]);
        s.setCount(array[1]);
        for (SoftDrink l : list) {
            if (l instanceof OrangeJuice) {
                l.setPrice(array[0]);
                int count = l.getCount() + array[1];
                l.setCount(count);
                break;
            }
        }
    }

    private SoftDrink check(int choice) {
        SoftDrink s = getSoftDrink(choice);
        int[] array = getInformation();
        s.setPrice(array[0]);
        s.setCount(array[1]);
        return s;
    }

    public void addNewCoca(int choice) {
        if (checkS(choice)) return;
        boolean check = true;
        for (SoftDrink softDrink : list) {
            if (softDrink instanceof Coca) {
                check = false;
                System.out.println(BlockStatic.HAD);
                break;
            }
        }
        check(choice, check);
    }

    public void addNewPepsi(int choice) {
        if (checkS(choice)) return;
        boolean check = true;
        for (SoftDrink softDrink : list) {
            if (softDrink instanceof Pepsi) {
                check = false;
                System.out.println(BlockStatic.HAD);
                break;
            }
        }
        check(choice, check);
    }

    public void addNewOrange(int choice) {
        if (checkS(choice)) return;
        boolean check = true;
        for (SoftDrink softDrink : list) {
            if (softDrink instanceof OrangeJuice) {
                check = false;
                System.out.println(BlockStatic.HAD);
                break;
            }
        }
        check(choice, check);
    }

    private void check(int choice, boolean check) {
        if (check) {
            addAll(choice);
        }
    }

    private boolean checkS(int choice) {
        if (list.size() == 3) {
            System.out.println(BlockStatic.IS_FULL);
            System.out.println(BlockStatic.ENTER_MORE_PRODUCTS);
            addOrange(choice);
            return true;
        }
        return false;
    }

    public void addAll(int choice) {
        list.add(check(choice));
    }

    private SoftDrink getSoftDrink(int choice) {
        SoftDrink s = null;
        switch (choice) {
            case 1 -> s = new Coca();
            case 2 -> s = new Pepsi();
            case 3 -> s = new OrangeJuice();
        }
        return s;
    }

    public void Show() {
        if (list.isEmpty()) {
            System.out.println("không có sản phẩm nào trong kho");
            return;
        }
        for (SoftDrink s : list) {
            System.out.println(s);
        }
    }

    public void updateFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sanpham.txt"));
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            System.err.println(BlockStatic.FILE_ERROR_WRITER);
            e.printStackTrace();
        }
    }

    public void updateReadFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sanpham.txt"));
            list = (List<SoftDrink>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ignored) {
            System.err.println(BlockStatic.ERROR_FILE_READ);
        }
    }


    // Hai mục
    public void addStaff() {
        System.out.println(BlockStatic.ENTER_NAME);
        String name = BlockStatic.sc.nextLine();
        System.out.println(BlockStatic.ENTER_AGE);
        int age = BlockStatic.sc.nextInt();
        System.out.println(BlockStatic.ENTER_HOMETOWN);
        BlockStatic.sc.nextLine();
        String hometown = BlockStatic.sc.nextLine();
        System.out.println(BlockStatic.ENTER_POSITION);
        String position = BlockStatic.sc.nextLine();
        System.out.println(BlockStatic.ENTER_SALARY);
        int salary = BlockStatic.sc.nextInt();
        System.out.println(BlockStatic.ENTER_OVERTIME);
        int overtime = BlockStatic.sc.nextInt();
        lists.add(new Staff(name, age, hometown, position, salary, overtime, list.size()));
        System.out.println(BlockStatic.ADD_SUCCESSFULLY);
        addFileO();
    }

    public void remove() {
        System.out.println(BlockStatic.ENTER_MNV);
        int index = checkIndex();
        if (index != -1) {
            lists.remove(index);
            System.out.println(BlockStatic.DELETER_SUCCESSFULLY);
            addFileO();
        } else {
            System.out.println(BlockStatic.NOT_MNV);
        }
    }

    private int checkIndex() {
        String str = BlockStatic.sc.nextLine();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getMSV().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void menu() {
        System.out.println(BlockStatic.ENTER_THE_OPTION);
        System.out.println("""
                1. Sửa tên\s
                2. Sửa tuổi\s
                3. Sửa quê quán\s
                4. Sửa chức vụ \s
                5. Sửa mức lương \s
                6. Sửa giờ làm thêm \s
                7. Sửa MNV \s""");
        System.out.println(BlockStatic.EXIT);
    }

    public void editStaff() {

        try {
            System.out.println(BlockStatic.ENTER_MNV_EDIT);
            int index = checkIndex();
            if (index == -1) {
                System.out.println(BlockStatic.NOT_MNV);
            } else {
                int choice;
                do {
                    menu();
                    choice = BlockStatic.sc.nextInt();
                    switch (choice) {
                        case 1 -> getName(index);

                        case 2 -> getAge(index);

                        case 3 -> getHometown(index);

                        case 4 -> getPosition(index);

                        case 5 -> getSalary(index);

                        case 6 -> getOverTime(index);

                        case 7 -> updateMNV(index);
                    }
                    System.out.println(" Sau khi cập nhật : ");
                    System.out.println(lists.get(index));
                    addFileO();
                } while (choice != 0);
            }
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
        }
    }

    private String updateMNV(int index) {
        return lists.get(index).getString(lists.get(index).getName(), lists.get(index).getPosition(), lists.size());
    }

    private void getOverTime(int index) {
        System.out.println(BlockStatic.ENTER_OVERTIME);
        int overTime = BlockStatic.sc.nextInt();
        lists.get(index).setOvertime(overTime);
    }

    private void getSalary(int index) {
        System.out.println(BlockStatic.ENTER_SALARY);
        int salary = BlockStatic.sc.nextInt();
        lists.get(index).setSalary(salary);
    }

    private void getPosition(int index) {
        System.out.println(BlockStatic.ENTER_POSITION);
        BlockStatic.sc.nextLine();
        String position = BlockStatic.sc.nextLine();
        lists.get(index).setPosition(position);
    }

    private void getHometown(int index) {
        System.out.println(BlockStatic.ENTER_HOMETOWN);
        BlockStatic.sc.nextLine();
        String hometown = BlockStatic.sc.nextLine();
        lists.get(index).setHometown(hometown);
    }

    private void getAge(int index) {
        System.out.println(BlockStatic.ENTER_AGE);
        int age = BlockStatic.sc.nextInt();
        lists.get(index).setAge(age);
    }

    private void getName(int index) {
        System.out.println(BlockStatic.ENTER_NAME);
        BlockStatic.sc.nextLine();
        String name = BlockStatic.sc.nextLine();
        lists.get(index).setName(name);
    }

    public void showList() {
        if (lists == null) {
            System.out.println(" Không có nhân viên nào được thuê ");
        } else {
            for (Staff staff : lists) {
                System.out.println(staff);
            }
        }
    }

    public void addFileO() {
        try {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("D:\\data.txt"));
            ois.writeObject(lists);
            ois.close();
        } catch (Exception e) {
            System.err.println(BlockStatic.FILE_ERROR_WRITER);
        }
    }

    public void readFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\data.txt"));
            lists = (List<Staff>) ois.readObject();
            ois.close();
        } catch (Exception b) {
            System.err.println(BlockStatic.ERROR_FILE_READ);
        }
    }

    public void addFileCSV() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\FileCaseStudy.csv", StandardCharsets.UTF_8));
            String[] str;
            for (SoftDrink softDrink : list) {
                str = softDrink.toString().split(",");
                for (String s : str) {
                    bw.write(s + ",");
                }
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            System.err.println(BlockStatic.FILE_ERROR_WRITER);
        }
    }

    public void readFileCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\FileCaseStudy.csv"));
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(BlockStatic.ERROR_FILE_READ);
        }
    }
}
