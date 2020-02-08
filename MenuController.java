import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private MenuStorage menuStorage;
    private RecipeStorage recipeStorage;

    public MenuController(MenuStorage menuStorage, RecipeStorage recipeStorage) {
        this.menuStorage = menuStorage;
        this.recipeStorage = recipeStorage;
    }

    public void create(String menuName, String kind, int price, List<String> recipeList) {
        if (checkSameName(menuName)) {
            if (!(kind.equals("wa") || kind.equals("yo") || kind.equals("chu"))) {
                System.out.println("Choose menu kind from wa or yo or chu");
            } else {
                menuStorage.add(new Menu(menuName, kind, price, recipeList));
            }
            System.out.println("created Menu!");
        } else {
            System.out.println("We have same Menu Name!!!!");
        }
    }

    public boolean checkSameName(String menuName) {
        for (Menu menu : menuStorage.getMenuList()
        ) {
            if (menu.getMenuName().equals(menuName)) {
                return false;
            }
        }
        return true;
    }

    public void showMenu(String name) {
        if (checkSameName(name)) {
            System.out.println("we dont have the menu!!");
        }
        Menu menu = menuStorage.getMenu(name);
        MenuView menuView = new MenuView();
        menuView.viewMenu(menu);
    }

    public void menuStatus(List<String> nameList) {
        List<Integer> totalPrice = new ArrayList<>();
        List<Integer> totalCal = new ArrayList<>();
        List<String> recipeNameList = new ArrayList<>();
        int totalMenuSize = nameList.size();

        for (String name : nameList
        ) {
            totalPrice.add(menuStorage.getMenu(name).getPrice());
            totalCal.add(recipeStorage.getCalByName(menuStorage.getMenu(name).getRecipeList()));
        }


        System.out.println("Average price : " + average(totalPrice));
        System.out.println("Max price : " + max(totalPrice));
        System.out.println("Min price : " + min(totalPrice));
        System.out.println("Average calories : " + total(totalCal) / totalMenuSize);
        System.out.println("Max calories : " + max(totalCal));
        System.out.println("Min calories : " + min(totalCal));
    }

    public List<String> getAllRecipeName() {
        List<String> result = new ArrayList<>();
        for (Menu menu : this.menuStorage.getMenuList()
        ) {
            result.add(menu.getMenuName());
        }
        return result;
    }

    public int getTotalMenuPrice(String menuName) {
        int result = 0;

        for (Menu menu : menuStorage.getMenuList()
        ) {
            if (menu.getMenuName().equals(menuName)) {
                result += menu.getPrice();
            }
        }
        return result;
    }

    public int total(List<Integer> list) {
        int result = 0;
        for (int num : list
        ) {
            result += num;
        }
        return result;
    }

    public int average(List<Integer> list) {
        int result = 0;
        int size = list.size();

        for (int num : list
        ) {
            result += num;
        }
        return result / size;
    }

    public int max(List<Integer> list) {
        int result = list.get(0);
        for (int num : list
        ) {
            if (result < num) {
                result = num;
            }
        }
        return result;
    }

    public int min(List<Integer> list) {
        int result = list.get(0);
        for (int num : list
        ) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}
