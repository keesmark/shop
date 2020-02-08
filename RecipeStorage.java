import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeStorage {
    private Map<String, Integer> recipeList;

    public RecipeStorage() {
        this.recipeList = new HashMap<>();
    }

    public Map<String, Integer> getRecipeList() {
        return this.recipeList;
    }

    public void add(Recipe recipe) {
        if (this.recipeList.containsKey(recipe.getRecipeName())) {
            System.out.println("Cant create same recipe name!!!");
        } else {
            recipeList.put(recipe.getRecipeName(), recipe.getCal());
            System.out.println("created recipe!");
        }
    }

    public int getCalByName(List<String> nameList) {
        int result = 0;
        for (String name : nameList
        ) {
            if (recipeList.containsKey(name)) {
                result += recipeList.get(name);
            }
        }
        return result;
    }
}
