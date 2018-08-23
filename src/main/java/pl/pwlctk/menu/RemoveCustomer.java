package pl.pwlctk.menu;

import pl.pwlctk.Customer;
import pl.pwlctk.RentalRepository;
import pl.pwlctk.RentalService;

import java.util.Set;

public class RemoveCustomer implements MenuItem {
    private RentalRepository rentalRepository;
    private RentalService rentalService;

    RemoveCustomer(RentalRepository rentalRepository, RentalService rentalService) {
        this.rentalRepository = rentalRepository;
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showAllCustomers();
        System.out.println("Podaj email użytkownika do usunięcia:");
        String email = Data.in.nextLine();
        removeCustomer(email);
        System.out.println("Użytkownik usunięty!");
    }

    @Override
    public String getHelpMessage() {
        return "Usuwanie użytkownika z bazy";
    }

    @Override
    public String getMenuName() {
        return "remove customer";
    }

    private void removeCustomer(String email) {
        Set<Customer> customers = rentalRepository.getCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                customers.remove(customer);
            }
        }
    }
}
