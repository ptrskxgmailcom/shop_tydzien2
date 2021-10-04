package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class ShopApplication {

    List<Basket> basketList;
    @Autowired
    ProductServis productService;

    public BasketService getBasketService() {
        return basketService;
    }

    @Autowired
    BasketService basketService;

    public static void main(String[] args) { SpringApplication.run(ShopApplication.class, args);
    }

@EventListener(ApplicationReadyEvent.class)
public void get() {

        System.out.println("Shop START");
        productService.showProduct();

        //Basket basket1 = new Basket();
        basketService.getBasketList().add(new Basket(productService.getVat(), productService.getDiscount()));

        for (int i=0;i<3;i++)
            basketService.getBasketList().get(0).addProduct2Basket(productService.getProductList().get(i));

        System.out.println("Profil START");
        basketService.getBasketList().get(0).showBasketStart();
}


}
