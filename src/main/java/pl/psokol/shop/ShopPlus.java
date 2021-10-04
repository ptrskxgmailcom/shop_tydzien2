package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("PLUS")
public class ShopPlus {

    @Autowired
    BasketService basketService;

    @EventListener(ApplicationReadyEvent.class)

    public void get(){
        System.out.println("profil PLUS");
        basketService.getBasketList().get(0).showBasketPlus();

    }
}
