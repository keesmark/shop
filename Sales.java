public class Sales {
    private String menuName;
    private int salesAmount;
    private int totalPrice;

    public String getMenuName() {
        return this.menuName;
    }

    public int getSalesAmount() {
        return this.salesAmount;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public Sales(String menuName, int salesAmount, int totalPrice) {
        this.menuName = menuName;
        this.salesAmount = salesAmount;
        this.totalPrice = totalPrice;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
