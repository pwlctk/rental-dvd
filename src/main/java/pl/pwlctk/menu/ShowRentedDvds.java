package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class ShowRentedDvds implements MenuItem {
    private RentalService rentalService;

    ShowRentedDvds(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showRentedDvd();
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla wypożyczone filmy wraz z nazwą użytkownika, który je wypożyczył";
    }

    @Override
    public String getMenuName() {
        return "show rented dvds";
    }
}
