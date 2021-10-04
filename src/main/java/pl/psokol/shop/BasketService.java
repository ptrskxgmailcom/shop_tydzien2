package pl.psokol.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    private List<Basket> basketList;
//    @Autowired
//    private ProductServis prodService;

    public BasketService() {
        basketList = new ArrayList<>();

    }

    public List<Basket> getBasketList() {
        return basketList;
    }
}
