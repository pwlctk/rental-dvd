package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class ShowAllCustomers implements MenuItem {
    private RentalService rentalService;

    public ShowAllCustomers(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showAllCustomers();
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla wszystkich zarejestrowanych użytkowników";
    }

    @Override
    public String getMenuName() {
        return "show all customers";
    }
}
