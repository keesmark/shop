public class MenuView {
    public void viewMenu(Menu menu) {
        System.out.println("Menu name : " + menu.getMenuName());
        System.out.println("kind : " + menu.getKind());
        System.out.println("price : " + menu.getPrice());
        System.out.println("Recipe : ");
        for (String recipename : menu.getRecipeList()
        ) {
            System.out.println(recipename);
        }
    }
}
