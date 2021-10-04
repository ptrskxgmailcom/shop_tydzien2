package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> prodList;
    private static int basketAmt = 0;
    private double vat;
    private double discount;
    private int basketNum;


    public static int incrementBasketAmtAndReturn() {
        return basketAmt = basketAmt + 1;
    }
    public Basket(double vat, double discount) {
        this.prodList = new ArrayList<>();
        this.basketNum = incrementBasketAmtAndReturn();
        this.vat = vat;
        this.discount = discount;
    }

    public List<Product> getprodList() {
        return prodList;
    }

    public void setprodList(List<Product> prodList) {
        this.prodList = prodList;
    }

    public void addProduct2Basket( Product product){
        this.prodList.add(product);
    }

    public void showBasketStart() {
        double sum = 0;

        prodList.forEach(System.out::println);
        for(int i = 0; i< prodList.size(); i++)
            sum += prodList.get(i).getPrice();
        sum = Math.round(sum * 100)/100;

        System.out.println("Basket" + this.basketNum + " {net=" + sum + "}");

    }

    public void showBasketPlus() {
        double sum = 0;
        double gross = 0;

        prodList.forEach(System.out::println);
        for(int i = 0; i< prodList.size(); i++)
            sum += prodList.get(i).getPrice();
        sum = Math.round(sum * 100)/100;
        gross = Math.round( sum * (1 + this.vat) * 100 ) / 100;

        System.out.println("Basket" + this.basketNum + " {net=" + sum + " gross=" + gross + "}");

    }
    public void showbasketPro() {
        double sum = 0;
        double gross = 0;
        double grossAfterDiscount = 0;

        prodList.forEach(System.out::println);
        for(int i = 0; i< prodList.size(); i++)
            sum += prodList.get(i).getPrice();
        sum = Math.round(sum * 100)/100;
        gross = Math.round( sum * (1 + vat) * 100 ) / 100;

        //sum * vat;
        grossAfterDiscount = Math.round(  gross * (1-this.discount) * 100 ) / 100;
        System.out.println("Basket" + this.basketNum + " {net=" + sum + " gross=" + gross + " gross after dicount " + grossAfterDiscount + "}");

    }

}
