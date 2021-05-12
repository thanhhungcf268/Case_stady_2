package CaseStudy;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Use {
    Map<String,Integer> map = new HashMap<>();
    private List<SoftDrink> list = new ArrayList<>();
    private final List<SoftDrink> listUse = new ArrayList<>();
    private SoftDrink softDrink = new SoftDrink();
    public void setList(List<SoftDrink> list){
        this.list = updateList(list);
    }
    public List<SoftDrink> getList(){
        setList(list);
        return list;
    }
    private List<SoftDrink> updateList(List<SoftDrink> l){
        l.removeIf(s -> s.getCount() == 0);
       return l;
    }
    private void oderCoca(){
        try {
            System.out.println(BlockStatic.ENTER_THE_BUY);
            int count = BlockStatic.sc.nextInt();
            for (SoftDrink s : getList()) {
                if (s instanceof Coca) {
                    int k = checkCount(s, count);
                    boolean check = true;
                    for (SoftDrink lis : listUse){
                        if (lis instanceof Coca){
                            check = false;
                            break;
                        }
                    }
                    if (check){
                        showOderCoca(k,s.getPrice());
                    }else {
                        int index = 1;
                        checkCountS(k,s.getPrice(),index);
                    }
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            oderCoca();
        }

    }
    private void oderPepsi(){
        try {
            System.out.println(BlockStatic.ENTER_THE_BUY);
            int count = BlockStatic.sc.nextInt();
            for (SoftDrink s : getList()) {
                if (s instanceof Pepsi) {
                    int k = checkCount(s, count);
                    boolean check = true;
                    for (SoftDrink lis : listUse){
                        if (lis instanceof Pepsi){
                            check = false;
                            break;
                        }
                    }
                    if (check){
                        showOderPepsi(k,s.getPrice());
                    }else {
                        int index = 2;
                        checkCountS(k,s.getPrice(),index);
                    }
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            oderPepsi();
        }

    }
    private void oderOrange(){
        try {
            System.out.println(BlockStatic.ENTER_THE_BUY);
            int count = BlockStatic.sc.nextInt();
            for (SoftDrink s : getList()) {
                if (s instanceof OrangeJuice) {
                    int k = checkCount(s, count);
                    boolean check = true;
                    for (SoftDrink lis : listUse){
                        if (lis instanceof OrangeJuice){
                            check = false;
                            break;
                        }
                    }
                    if (check){
                        showOderOrange(k,s.getPrice());
                    }else {
                        int index = 3;
                        checkCountS(k,s.getPrice(),index);
                    }
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            oderOrange();
        }
    }

    private int checkCount(SoftDrink s, int count) {
        int k;
        if (s.getCount() == 0) {
            System.out.println(" Hết hàng ! ");
            return -1;
        }
        if (s.getCount() < count) {
            k = s.getCount();
            s.setCount(0);
        } else {
            k =count;
            s.setCount(s.getCount() - count);
        }
        return k;
    }

    private void menu() {
        System.out.println(BlockStatic.ENTER_THE_OPTION);
        System.out.println(BlockStatic.COCA);
        System.out.println(BlockStatic.PEPSI);
        System.out.println(BlockStatic.ORANGE);
        System.out.println(BlockStatic.EXIT);
    }

    public void ro_Hang(){
        try {
            int choice;
            do {
                menu();
                choice = BlockStatic.sc.nextInt();
                switch (choice){
                    case 1->oderCoca();
                    case 2->oderPepsi();
                    case 3->oderOrange();
                }
            }while (choice!=0);
        }catch (Exception e){
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            ro_Hang();
        }

    }
    public void showHang(){
        try {
            for (SoftDrink s : getList()){
                System.out.println(s);
            }
        }catch (Exception ignored){
        }

    }
    private int tinh_Tien(int k,int price){
        return k*price;
    }
    private void showOderCoca(int k,int price){
        if (k!=-1){
            softDrink = new Coca();
            softDrink.setCount(k);
            softDrink.addPrice(tinh_Tien(softDrink.getCount(),price));
            listUse.add(softDrink);
        }
    }
    private void showOderPepsi(int k,int price){
        if (k!=-1){
            softDrink = new Pepsi();
            softDrink.setCount(k);
            softDrink.addPrice(tinh_Tien(softDrink.getCount(),price));
            listUse.add(softDrink);
        }

    }
    private void showOderOrange(int k,int price){
        if (k!=-1){
            softDrink = new OrangeJuice();
            softDrink.setCount(k);
            softDrink.addPrice(tinh_Tien(softDrink.getCount(),price));
            listUse.add(softDrink);
        }
    }
    private void checkCountS(int k,int price,int index){
        if (k==-1){
            return;
        }
        if (index==1){
            for (SoftDrink l : listUse){
                if (l instanceof Coca){
                    l.setCount(l.getCount()+k);
                    l.setPrice(l.getPrice()+tinh_Tien(k,price));
                    break;
                }
            }
        }else if (index==2){
            for (SoftDrink l : listUse){
                if (l instanceof Pepsi){
                    l.setCount(l.getCount()+k);
                    l.setPrice(l.getPrice()+tinh_Tien(k,price));
                    break;
                }
            }
        }else {
            for (SoftDrink l : listUse){
                if (l instanceof OrangeJuice){
                    l.setCount(l.getCount()+k);
                    l.setPrice(l.getPrice()+tinh_Tien(k,price));
                    break;
                }
            }
        }

    }
    private int total(){
        int total = 0;
        for (SoftDrink softDrink : listUse){
            total +=softDrink.getPrice();
        }
        addFileOfTotal(total);
        Admin.total += total;
        return total;
    }
    public void updateFileTotal(){
        try {
            File f = new File("D:\\total.csv");
            if (!f.exists()||f.length()==0){
                return;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\total.csv"));
            map = (Map<String, Integer>) ois.readObject();
            ois.close();
        }catch (Exception e){
            System.err.println(BlockStatic.ERROR_FILE_READ);
        }
    }
    private void addFileOfTotal(int total){
        LocalDateTime ld = LocalDateTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh-dd-MMM-yyyy");
        String str = ld.format(dt);
        map.put(str,total);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\total.csv"));
            oos.writeObject(map);
            oos.close();
        }catch (Exception e){
            System.err.println(BlockStatic.FILE_ERROR_WRITER);
        }
    }
    public void showTheRow(){
        if (listUse.isEmpty()){
            System.out.println(" Rỏ hàng rỗng");
            return;
        }
        for (SoftDrink softDrink1 : listUse){
            if (softDrink1 instanceof Coca){
                System.out.println("Mặt hàng Coca với giá trị là : "+softDrink1.getPrice()+" Tổng số lượng là  : "+softDrink1.getCount());
            }
            if (softDrink1 instanceof Pepsi){
                System.out.println("Mặt hàng Pepsi với giá trị là : "+softDrink1.getPrice()+" Tổng số lượng là  : "+softDrink1.getCount());
            }
            if (softDrink1 instanceof OrangeJuice){
                System.out.println("Mặt hàng Orange với giá trị là : "+softDrink1.getPrice()+" Tổng số lượng là  : "+softDrink1.getCount());

            }
        }
        System.out.println(" Tổng phải thanh toán là " + total());
    }
}
