import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RecipeStorage recipeStorage = new RecipeStorage();
        RecipeController recipeController = new RecipeController(recipeStorage);
        MenuStorage menuStorage = new MenuStorage();
        MenuController menuController = new MenuController(menuStorage, recipeStorage);
        StockStorage stockStorage = new StockStorage();
        StockController stockController = new StockController(stockStorage, menuStorage);
        SalesStorage salesStorage = new SalesStorage();
        SalesController salesController = new SalesController(salesStorage, menuController, stockStorage);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print(">");
                String line = reader.readLine();
                List<String> commandLine = Arrays.asList(line.split(" "));
                int commandSize = commandLine.size();

                switch (commandLine.get(0)) {
                    case "makerecipe":
                        recipeController.create(commandLine.get(1), Integer.parseInt(commandLine.get(2)));
                        break;
                    case "showrecipe":
                        recipeController.searchRecipe(commandLine.get(1));
                        break;

                    case "makemenu":
                        List<String> nameList = new ArrayList<>();
                        for (int i = 4; i < commandLine.size(); i++) {
                            nameList.add(commandLine.get(i));
                        }
                        menuController.create(commandLine.get(1), commandLine.get(2), Integer.parseInt(commandLine.get(3)), nameList);
                        break;

                    case "showmenu":
                        menuController.showMenu(commandLine.get(1));
                        break;

                    case "menustatus":
                        List<String> menuNameList = new ArrayList<>();
                        if (commandSize == 1) {
                            menuNameList = menuController.getAllRecipeName();
                        } else {
                            for (int i = 1; i < commandLine.size(); i++) {
                                menuNameList.add(commandLine.get(i));
                            }
                        }
                        menuController.menuStatus(menuNameList);
                        break;

                    case "showstock":
                        if (commandSize == 1) {
                            stockController.getAllStocks();
                        } else if (commandSize == 2) {
                            if (commandLine.get(1).equals("wa") || commandLine.get(1).equals("yo") || commandLine.get(1).equals("chu")) {
                                stockController.getKindStock(commandLine.get(1));
                            } else {
                                stockController.getStockByName(commandLine.get(1));
                            }
                        } else {
                            throw new ShopRuntimeException("command error!!");
                        }
                        break;

                    case "addstock":
                        stockController.addToStock(commandLine.get(1), Integer.parseInt(commandLine.get(2)));
                        break;

                    case "delstock":
                        stockController.delToStock(commandLine.get(1), Integer.parseInt(commandLine.get(2)));
                        break;

                    case "buy":
                        List<String> menuCommandList = new ArrayList<>();
                        for (int i = 2; i < commandSize; i++) {
                            menuCommandList.add(commandLine.get(i));
                        }
                        salesController.buy(Integer.parseInt(commandLine.get(1)), menuCommandList);
                        break;

                    case "showsales":
                        salesController.showSales();
                        break;

                    case "exit":
                        System.out.println("bye!!close application");
                        reader.close();
                }
            }
        } catch (Exception e) {
            System.err.println("something wrong...");
        }
    }
}