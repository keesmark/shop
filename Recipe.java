public class Recipe {
    private String recipeName;
    private int cal;

    public Recipe(String recipeName, int cal) {
        this.recipeName = recipeName;
        this.cal = cal;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public int getCal() {
        return this.cal;
    }
}
