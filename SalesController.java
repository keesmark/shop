import java.util.ArrayList;
import java.util.List;

public class SalesController {
    private SalesStorage salesStorage;
    private MenuController menuController;
    private StockStorage stockStorage;

    public SalesController(SalesStorage salesStorage, MenuController menuController, StockStorage stockStorage) {
        this.salesStorage = salesStorage;
        this.menuController = menuController;
        this.stockStorage = stockStorage;
    }

    public void buy(int money, List<String> nameList) {
        int totalPrice = 0;
        List<Pair<String, Integer>> namePricePair = new ArrayList<>();

        for (String name : nameList
        ) {
            if (menuController.checkSameName(name)) {
                System.out.println("We dont have the Menu!!!");
            } else {
                if (1 <= stockStorage.getStockListByName(name).getValue2()) {
                    totalPrice += menuController.getTotalMenuPrice(name);
                    namePricePair.add(new Pair<>(name, menuController.getTotalMenuPrice(name)));
                    stockStorage.getStockListByName(name).setValue2(stockStorage.getStockListByName(name).getValue2() - 1);
                } else {
                    System.out.println("No enough stock amount!!!!");
                }
            }
        }

        if (totalPrice <= money) {
            for (Pair<String, Integer> pair : namePricePair
            ) {
                salesStorage.add(pair.getValue1(), pair.getValue2());
            }
        } else {
            System.out.println("Not enough Money!!!");
        }
    }

    public void showSales() {
        for (Sales sales : salesStorage.getSalesList()
        ) {
            System.out.println(sales.getMenuName() + " : " + "Total price : " + sales.getTotalPrice() + " Total amount : " + sales.getSalesAmount());
        }
    }
}
