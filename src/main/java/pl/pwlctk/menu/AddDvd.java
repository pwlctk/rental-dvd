package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class AddDvd implements MenuItem {
    private RentalService rentalService;

    AddDvd(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        System.out.println("Dodawnie DVD do bazy");
        System.out.print("Podaj tytuł: ");
        String title = Data.in.nextLine();
        System.out.println("Podaj gatunek: ");
        String genere = Data.in.nextLine();
        System.out.println("Podaj rok produkcji: ");
        int relaseDate = Data.in.nextInt();

        rentalService.addDvd(title, genere, relaseDate);
        System.out.println("DVD dodano pomyślnie!");
    }

    @Override
    public String getHelpMessage() {
        return "Dodaje nowe DVD do bazy";
    }

    @Override
    public String getMenuName() {
        return "add dvd";
    }
}
