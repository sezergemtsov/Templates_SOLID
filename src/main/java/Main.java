public class Main {
    public static void main(String[] args) {
        GoodsStorage warehouse = new Warehouse();
        Goods vacuumCleaner1 = new Goods("Vacuum cleaner",GOODS_TYPE.PRODUCTS_FOR_HOME);
        vacuumCleaner1.setPrice(5_500);
        vacuumCleaner1.setVendor("LG");
        warehouse.addGoods(vacuumCleaner1);
        warehouse.addGoods(vacuumCleaner1);
        warehouse.addGoods(vacuumCleaner1);
        Goods vacuumCleaner2 = new Goods("Vacuum cleaner",GOODS_TYPE.PRODUCTS_FOR_HOME);
        vacuumCleaner2.setVendor("Dyson");
        vacuumCleaner2.setPrice(23_900);
        warehouse.addGoods(vacuumCleaner2);
        Goods vacuumCleaner3 = new Goods("Vacuum cleaner Robot",GOODS_TYPE.PRODUCTS_FOR_HOME);
        vacuumCleaner3.setVendor("MI");
        vacuumCleaner3.setPrice(19_900);
        warehouse.addGoods(vacuumCleaner3);
        warehouse.addGoods(vacuumCleaner3);
        Goods microwave = new Goods("Microwave",GOODS_TYPE.PRODUCTS_FOR_KITCHEN);
        microwave.setVendor("LG");
        microwave.setPrice(17_900);
        warehouse.addGoods(microwave);
        Goods microwave1 = new Goods("Microwave",GOODS_TYPE.PRODUCTS_FOR_KITCHEN);
        microwave1.setVendor("DEXP");
        microwave1.setPrice(5_500);
        warehouse.addGoods(microwave1);
        warehouse.addGoods(microwave1);
        Goods alarmClock = new Goods("Alarm Clock",GOODS_TYPE.ELECTRONICS);
        alarmClock.setPrice(2_900);
        alarmClock.setVendor("Casio");
        warehouse.addGoods(alarmClock);

        Customer customer = new Customer(warehouse);
        customer.purchasing();

    }
}
