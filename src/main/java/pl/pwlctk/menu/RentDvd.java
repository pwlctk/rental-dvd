package pl.pwlctk.menu;

import pl.pwlctk.Customer;
import pl.pwlctk.Dvd;
import pl.pwlctk.RentalRepository;
import pl.pwlctk.RentalService;

import java.util.Optional;
import java.util.Set;

public class RentDvd implements MenuItem {
    private RentalRepository rentalRepository;
    private RentalService rentalService;

    RentDvd(RentalRepository rentalRepository, RentalService rentalService) {
        this.rentalRepository = rentalRepository;
        this.rentalService = rentalService;
    }

    @Override
    public void call() {
        rentalService.showAllCustomers();
        System.out.println("Podaj email użytkownika:");
        String email = Data.in.nextLine();
        Optional<Customer> customer = getCustomer(email);

        if (customer.isPresent()) {
            Customer rentCustomer = customer.get();
            System.out.println("Użytkownik: " + rentCustomer.getName() + " " + rentCustomer.getLastName());

            rentalService.showAvailableDvd();

            System.out.println("Proszę podać tytuł filmu do wypożyczenia:");
            String title = Data.in.nextLine();
            Optional<Dvd> dvd = getDvd(title);
            if (dvd.isPresent()) {
                rentDvdToCustomer(dvd.get(), rentCustomer);
            } else {
                System.out.println("Nie znaleziono takiego filmu w bazie!");
            }

        } else {
            System.out.println("Nie znaleziono użytkownika o podanym email!");
        }
    }

    @Override
    public String getHelpMessage() {
        return "Wypożyczanie filmu dla użytkownika";
    }

    @Override
    public String getMenuName() {
        return "rent dvd";
    }

    private Optional<Customer> getCustomer(String email) {
        Set<Customer> customers = rentalRepository.getCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    private Optional<Dvd> getDvd(String title) {
        Set<Dvd> dvds = rentalRepository.getDvds();
        for (Dvd dvd : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                return Optional.of(dvd);
            }
        }
        return Optional.empty();
    }

    private void rentDvdToCustomer(Dvd dvd, Customer customer) {
        rentalService.rentDvdToCustomer(dvd, customer);
    }
}
