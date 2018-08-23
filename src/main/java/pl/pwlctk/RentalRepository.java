package pl.pwlctk;

import java.util.LinkedHashSet;
import java.util.Set;

public class RentalRepository {
    private Set<Dvd> dvds = new LinkedHashSet<>();
    private Set<Customer> customers = new LinkedHashSet<>();

    public Set<Dvd> getDvds() {
        return dvds;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void addDvd(Dvd dvd) {
        dvds.add(dvd);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
