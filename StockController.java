import java.util.ArrayList;
import java.util.List;

public class StockController {
    private StockStorage stockStorage;
    private MenuStorage menuStorage;

    public StockController(StockStorage stockStorage, MenuStorage menuStorage) {
        this.stockStorage = stockStorage;
        this.menuStorage = menuStorage;
    }

    public void addToStock(String name, int amount) {
        if (checkMenuName(name)) {
            if (!stockStorage.nameCheck(name)) {
                stockStorage.addAmount(name, amount);
            } else {
                stockStorage.add(new Stock(name, amount));
            }
        } else {
            System.out.println("We dont have the Menu name!!!");
        }
    }

    public void delToStock(String name, int amount) {
        if (checkMenuName(name)) {
            if (!stockStorage.nameCheck(name)) {
                stockStorage.delAmount(name, amount);
            }
        } else {
            System.out.println("We dont have the Menu name!!!");
        }
    }

    public void getAllStocks() {
        for (Pair<String, Integer> pair : stockStorage.getStockPairList()
        ) {
            System.out.println("Menu name : " + pair.getValue1() + " Stock amount : " + pair.getValue2());
        }
    }

    public void getKindStock(String kind) {
        List<String> nameList = getKindMenu(kind);
        for (String name : nameList
        ) {
            System.out.println(stockStorage.getStockListByName(name).getValue1() + " : " + stockStorage.getStockListByName(name).getValue2());
        }
    }

    public List<String> getKindMenu(String kind) {
        List<String> result = new ArrayList<>();

        for (Menu menu : menuStorage.getMenuList()
        ) {
            if (menu.getKind().equals(kind)) {
                result.add(menu.getMenuName());
            }
        }
        return result;
    }

    public void getStockByName(String name) {
        System.out.println(
                stockStorage.getStockListByName(name).getValue1() + " : " + stockStorage.getStockListByName(name).getValue2()
        );

    }

    public boolean checkMenuName(String name) {
        for (Menu menu : menuStorage.getMenuList()
        ) {
            if (menu.getMenuName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkStockAmount(String name) {
        for (Pair<String, Integer> pair : stockStorage.getStockPairList()
        ) {
            if (pair.getValue1().equals(name) && 1 <= pair.getValue2()) {
                return true;
            }
        }

        return false;
    }
}
