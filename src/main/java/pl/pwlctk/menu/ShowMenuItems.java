package pl.pwlctk.menu;

import java.util.Map;

public class ShowMenuItems implements MenuItem {
    private Map<String, MenuItem> menuItems;

    ShowMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void call() {
        for(MenuItem menu : menuItems.values()){
            System.out.println(menu.getMenuName() + " - " + menu.getHelpMessage());
        }
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla dostępne opcje";
    }

    @Override
    public String getMenuName() {
        return "help";
    }
}
