package pl.pwlctk.menu;

import pl.pwlctk.RentalRepository;
import pl.pwlctk.RentalService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuRunner {
    private Map<String, MenuItem> menuItems = new HashMap<>();

    public MenuRunner(RentalRepository rentalRepository, RentalService rentalService) {
        addMenuItem(new Exit());
        addMenuItem(new ShowMenuItems(menuItems));
        addMenuItem(new AddDvd(rentalService));
        addMenuItem(new ShowAllDvds(rentalService));
        addMenuItem(new RemoveDvd(rentalRepository, rentalService));
        addMenuItem(new AddCustomer(rentalService));
        addMenuItem(new ShowAllCustomers(rentalService));
        addMenuItem(new RemoveCustomer(rentalRepository, rentalService));
        addMenuItem(new RentDvd(rentalRepository, rentalService));
        addMenuItem(new ShowRentedDvds(rentalService));
        addMenuItem(new ShowDvdByGenre(rentalService));
    }

    private void addMenuItem(MenuItem menuItem) {
        String key = menuItem.getMenuName().toUpperCase();
        this.menuItems.put(key, menuItem);
    }

    private Optional<MenuItem> getMenu(String choice) {
        return Optional.ofNullable(menuItems.get(choice.trim().toUpperCase()));
    }

    public void runMenu(String choice) {
        Optional<MenuItem> menuItem = getMenu(choice);
        if (menuItem.isPresent()) {
            menuItem.get().call();
        } else {
            System.out.println("Niepoprawna komenda! Wpisz help aby wyświetlić listę komend");
        }
    }
}
