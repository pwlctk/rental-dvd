package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class ShowAllDvds implements MenuItem {
    private RentalService rentalService;

    ShowAllDvds(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showAllDvd();
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla wszystkie płyty DVD dostępne w wypożyczalni";
    }

    @Override
    public String getMenuName() {
        return "show all dvds";
    }
}
