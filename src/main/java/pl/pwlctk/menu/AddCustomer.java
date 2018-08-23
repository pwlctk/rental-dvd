package pl.pwlctk.menu;

import pl.pwlctk.RentalService;

public class AddCustomer implements MenuItem {
    private RentalService rentalService;

    AddCustomer(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        System.out.println("Dodawnie klienta do bazy");
        System.out.print("Podaj imię: ");
        String name = Data.in.nextLine();
        System.out.println("Podaj nazwisko: ");
        String lastName = Data.in.nextLine();
        System.out.println("Podaj email: ");
        String email = Data.in.nextLine();

        rentalService.addCustomer(name, lastName, email);
        System.out.println("Użytkownik dodany pomyślnie!");
    }

    @Override
    public String getHelpMessage() {
        return "Dodaje nowego klienta do bazy";
    }

    @Override
    public String getMenuName() {
        return "add customer";
    }
}
