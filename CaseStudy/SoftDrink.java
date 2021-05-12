package CaseStudy;

import java.io.Serializable;

public class SoftDrink implements Serializable {
    private int price;
    private int count = 0;

    public SoftDrink() {
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
//        this.price = price*1.1+1;
        this.price = (price/100*10)+price+1;
    }
    public void addPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Giá  : " + price+"/1 sản phẩm  số lượng hiện tại là "+ count;
    }
}
