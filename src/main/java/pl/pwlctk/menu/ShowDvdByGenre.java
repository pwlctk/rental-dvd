package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class ShowDvdByGenre implements MenuItem {
    private RentalService rentalService;

    ShowDvdByGenre(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        System.out.println("Podaj gatunek: ");
        String genere = Data.in.nextLine();
        rentalService.showDvdsByGenre(genere);
    }

    @Override
    public String getHelpMessage() {
        return "Wyświetla listę wszystkich DVD posortowanych według gatunków";
    }

    @Override
    public String getMenuName() {
        return "show genre";
    }

}
