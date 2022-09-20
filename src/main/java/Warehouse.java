import java.util.ArrayList;
import java.util.List;

public class Warehouse implements GoodsStorage{

    List<Goods> stock = new ArrayList();

    @Override
    public boolean addGoods(Goods goods) {
        return stock.add(goods);
    }

    @Override
    public boolean pullGoods(Goods goods) {
        return stock.remove(goods);
    }

    @Override
    public List<Goods> getStock() {
        return stock;
    }
}
