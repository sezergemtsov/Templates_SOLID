import java.util.ArrayList;
import java.util.List;

public class CustomersBasket implements GoodsStorage{

    List<Goods> stockClone;
    List<Goods> basket;

    public CustomersBasket(GoodsStorage warehouse) {
        basket = new ArrayList<>();
        stockClone = warehouse.getStock();
    }

    @Override
    public boolean addGoods(Goods goods) {
        if (stockClone.remove(goods)) {
            return basket.add(goods);
        }
        return false;
    }

    @Override
    public boolean pullGoods(Goods goods) {
        if (basket.remove(goods)) {
            stockClone.add(goods);
            return true;
        }
        return false;
    }

    @Override
    public List<Goods> getStock() {
        return basket;
    }
}
