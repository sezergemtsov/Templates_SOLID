import java.util.ArrayList;
import java.util.List;

public interface GoodsStorage {
    boolean addGoods(Goods goods);
    boolean pullGoods(Goods goods);
    List<Goods> getStock();
}
