package pl.pwlctk;

import java.util.Set;

public class RentalService {
    private RentalRepository rentalRepository;
    private Set<Dvd> dvds;
    private Set<Customer> customers;

    RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
        this.dvds = rentalRepository.getDvds();
        this.customers = rentalRepository.getCustomers();
    }

    public void addDvd(String title, String genere, int relaseDate) {
        rentalRepository.addDvd(new Dvd(title, genere, relaseDate));
    }

    public void addCustomer(String name, String lastName, String email) {
        rentalRepository.addCustomer(new Customer(name, lastName, email));
    }

    public void showAllDvd() {
        System.out.println("Lista wszystkich płyt DVD w wypożyczalni:");
        System.out.println("==================================================");
        int counter = 1;
        for (Dvd dvd : dvds) {
            System.out.println("Pozycja: " + counter++);
            System.out.println("Tytuł: " + dvd.getTitle());
            System.out.println("Gatunek: " + dvd.getGenere());
            System.out.println("Rok produkcji: " + dvd.getReleaseDate());
            System.out.println("Dostępność: " + (dvd.isCurrentlyRented() ? "Brak" : "Dostępny"));
            System.out.println("==================================================");
        }
    }

    public void showAllCustomers() {
        System.out.println("Lista wszystkich klientów wypożyczalni:");
        System.out.println("==================================================");
        int counter = 1;
        for (Customer customer : customers) {
            System.out.println("Klient numer: " + counter++);
            System.out.println("Imię: " + customer.getName());
            System.out.println("Nazwisko: " + customer.getLastName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Wypożyczone filmy: " + customer.showRentedDvd());
            System.out.println("==================================================");
        }
    }

    public void showAvailableDvd() {
        System.out.println("Lista dostępnych płyt DVD w wypożyczalni:");
        System.out.println("==================================================");
        int counter = 1;
        for (Dvd dvd : dvds) {
            if (!dvd.isCurrentlyRented()) {
                System.out.println("Pozycja: " + counter++);
                System.out.println("Tytuł: " + dvd.getTitle());
                System.out.println("Gatunek: " + dvd.getGenere());
                System.out.println("Rok produkcji: " + dvd.getReleaseDate());
                System.out.println("==================================================");
            }
        }
    }

    public void showRentedDvd() {
        System.out.println("Lista filmów wypożyczonych:");
        System.out.println("==================================================");
        int counter = 1;
        for (Dvd dvd : dvds) {
            if (dvd.isCurrentlyRented()) {
                System.out.println("Pozycja: " + counter++);
                System.out.println("Tytuł: " + dvd.getTitle());
                System.out.println("Gatunek: " + dvd.getGenere());
                System.out.println("Rok produkcji: " + dvd.getReleaseDate());
                System.out.println("Wypożyczył: " + dvd.getCustomer().getFullName());
                System.out.println("==================================================");
            }
        }
    }

    public void rentDvdToCustomer(Dvd dvd, Customer customer) {
        dvd.rent(customer);
        customer.getRentedDvds().add(dvd);
    }

    public void showDvdsByGenre(String genre) {
        System.out.println("Lista filmów z gatunku: " + genre);
        System.out.println("==================================================");
        int counter = 1;
        for (Dvd dvd : dvds) {
            String dvdGenre = dvd.getGenere().toUpperCase();
            if (dvdGenre.contains(genre.toUpperCase())) {
                System.out.println("Pozycja: " + counter++);
                System.out.println("Tytuł: " + dvd.getTitle());
                System.out.println("Gatunek: " + dvd.getGenere());
                System.out.println("Rok produkcji: " + dvd.getReleaseDate());
                System.out.println("Dostępność: " + (dvd.isCurrentlyRented() ? "Brak" : "Dostępny"));
                System.out.println("==================================================");
            }
        }
    }
}

