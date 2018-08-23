package pl.pwlctk;

import pl.pwlctk.menu.MenuRunner;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        RentalRepository rentalRepository = new RentalRepository();
        RentalService rentalService = new RentalService(rentalRepository);

        MenuRunner menuRunner = new MenuRunner(rentalRepository, rentalService);

        Scanner scanner = new Scanner(System.in);
        String choice;

        rentalService.addDvd("K-Pax", "Dramat, Sci-Fi", 2001);
        rentalService.addDvd("Vanilla Sky", " Fantasy, Mystery, Romance", 2001);
        rentalService.addDvd("Matrix", "Action, Sci-Fi", 1999);

        rentalService.addCustomer("Rafał", "Kosmo","rafal.kosmita@kosmici.pl");
        rentalService.addCustomer("Janusz", "Mondry","niemam@maila.com");
        rentalService.addCustomer("Grażyna", "Mondszejrza","grazyna@pwn.pl");

        System.out.println("Wypożyczalnia płyt DVD! Wybierz opcję:");
        do {
            System.out.println("Polecenie: ");
            choice = scanner.nextLine();
            menuRunner.runMenu(choice);
        } while (!choice.equalsIgnoreCase("exit"));

    }
}
