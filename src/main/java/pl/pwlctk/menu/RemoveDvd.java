package pl.pwlctk.menu;

import pl.pwlctk.Dvd;
import pl.pwlctk.RentalRepository;
import pl.pwlctk.RentalService;

import java.util.Set;

public class RemoveDvd implements MenuItem {
    private RentalRepository rentalRepository;
    private RentalService rentalService;

    RemoveDvd(RentalRepository rentalRepository, RentalService rentalService) {
        this.rentalRepository = rentalRepository;
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showAllDvd();
        System.out.println("Podaj tytuł filmu do usunięcia:");
        String title = Data.in.nextLine();
        removeDvd(title);
        System.out.println("Film usunięty!");
    }

    @Override
    public String getHelpMessage() {
        return "Usuwanie DVD z bazy";
    }

    @Override
    public String getMenuName() {
        return "remove dvd";
    }

    private void removeDvd(String title) {
        Set<Dvd> dvds = rentalRepository.getDvds();
        for (Dvd dvd : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                dvds.remove(dvd);
            }
        }
    }
}
