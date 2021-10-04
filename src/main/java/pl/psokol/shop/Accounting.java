package pl.psokol.shop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "accounting")
public class Accounting {
    private double vat;
    private double discount;

    public double getVat() {
        return vat;
    }

    public void setVat(double inVat) {
        vat = inVat;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double inDiscount) {
        discount = inDiscount;
    }
}
