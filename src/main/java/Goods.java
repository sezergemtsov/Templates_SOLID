public class Goods {
    public final String goodsName;
    public final GOODS_TYPE goods_type;

    private boolean isAvailable;
    private double price;
    private int rating;
    private String vendor;

    public Goods(String goodsName, GOODS_TYPE goods_type) {
        this.goodsName = goodsName;
        this.goods_type = goods_type;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public String toString() {
        return goodsName + " " + vendor + " " + "Price: " + price;
    }
}
