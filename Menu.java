import java.util.List;

public class Menu {
    private String menuName;
    private String kind;
    private int price;
    private List<String> recipeList;

    public String getMenuName() {
        return this.menuName;
    }

    public String getKind() {
        return this.kind;
    }

    public int getPrice() {
        return this.price;
    }

    public List<String> getRecipeList() {
        return this.recipeList;
    }

    public Menu(String menuName, String kind, int price, List<String> recipeList) {
        this.menuName = menuName;
        this.kind = kind;
        this.price = price;
        this.recipeList = recipeList;
    }
}
