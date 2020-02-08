public class RecipeController {
    private RecipeStorage recipeStorage;

    public RecipeController(RecipeStorage recipeStorage) {
        this.recipeStorage = recipeStorage;
    }

    public void create(String recipeName, int cal) {
        recipeStorage.add(new Recipe(recipeName, cal));
    }

    public void searchRecipe(String name) {
        if (recipeStorage.getRecipeList().containsKey(name)) {
            System.out.println("Recipe name : " + name + "Calories : " + recipeStorage.getRecipeList().get(name));
        } else {
            System.out.println("we dont have the recipe name!!!");
        }
    }
}
