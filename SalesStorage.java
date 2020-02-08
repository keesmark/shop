import java.util.ArrayList;
import java.util.List;

public class SalesStorage {
    private List<Sales> salesList;

    public SalesStorage() {
        this.salesList = new ArrayList<>();
    }

    public List<Sales> getSalesList() {
        return this.salesList;
    }

    public void add(String menuName, int price) {
        for (Sales sales : this.salesList
             ) {
            if (sales.getMenuName().equals(menuName)) {
                sales.setTotalPrice(sales.getTotalPrice() + price);
                sales.setSalesAmount(sales.getSalesAmount() + 1);
                return;
            }
        }
        this.salesList.add(new Sales(menuName, 1, price));
    }
}
