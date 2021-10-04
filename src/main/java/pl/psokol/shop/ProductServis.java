package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServis {

    private List<Product> productList;
    private Accounting accounting;
    private static double pMin = 5;
    private static double pMax = 300;
    private static double scale = 100;
    private double vat;
    private double discount;

    private static double calculatePrice(){

        return Math.round(( Math.random() * (pMax - pMin) + pMin ) * scale ) / scale;
    }

    public double getVat() {
        return this.vat;
    }

    public void setVat(double inVat) {
        this.vat = inVat;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Autowired
    public ProductServis(@Qualifier("accounting") Accounting accounting) {
        this.accounting = accounting;
        this.vat = accounting.getVat();
        this.discount = accounting.getDiscount();

        Product prod1 = new Product("koło",  calculatePrice() );
        Product prod2 = new Product("szprycha", calculatePrice() );
        Product prod3 = new Product("widelec", calculatePrice() );
        Product prod4 = new Product("pedał", calculatePrice() );
        Product prod5 = new Product("siodełko", calculatePrice() );

        productList = new ArrayList<>();
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);
        productList.add(prod5);

    }

    public List<Product> getProductList() {
        return productList;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void showProduct(){
        double sum = 0;

        productList.forEach(System.out::println);

        for(int i=0;i<productList.size();i++)
            sum += productList.get(i).getPrice();
        sum = Math.round(sum * 100)/100;
        System.out.println("sum->" + sum);

        System.out.println("prodyctSrvice " + getVat() + "  " + getDiscount() );

    }

}
