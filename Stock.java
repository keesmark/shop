public class Stock {
    private String menuName;
    private int menuStock;

    public Stock(String menuName, int menuStock) {
        this.menuName = menuName;
        this.menuStock = menuStock;
    }

    public void setMenuStock(int menuStock) {
        this.menuStock = menuStock;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getMenuStock() {
        return this.menuStock;
    }
}
