import java.util.ArrayList;
import java.util.List;

public class MenuStorage {
    private List<Menu> menuList;

    public MenuStorage() {
        this.menuList = new ArrayList<>();
    }

    public List<Menu> getMenuList() {
        return this.menuList;
    }

    public Menu getMenu(String name) {
        Menu result = null;
        for (Menu menu : this.getMenuList()
        ) {
            if (menu.getMenuName().equals(name)) {
                result = menu;
            }
        }
        return result;
    }

    public void add(Menu menu) {
        this.menuList.add(menu);
    }

}
