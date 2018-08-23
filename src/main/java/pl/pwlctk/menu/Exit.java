package pl.pwlctk.menu;

public class Exit implements MenuItem {
    @Override
    public void call() {
        System.out.println("Do widzenia!");
        System.exit(0);
    }

    @Override
    public String getHelpMessage() {
        return "Wyjście z aplikacji";
    }

    @Override
    public String getMenuName() {
        return "exit";
    }
}
