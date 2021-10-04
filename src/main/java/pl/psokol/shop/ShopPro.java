package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("PRO")
public class ShopPro {
    @Autowired
    BasketService basketService;

    @EventListener(ApplicationReadyEvent.class)

    public void get(){
        System.out.println("profil PRO");
        basketService.getBasketList().get(0).showbasketPro();
    }
}
