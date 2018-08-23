package pl.pwlctk;

import java.util.LinkedHashSet;
import java.util.Set;

public class Customer {
    private String name;
    private String lastName;
    private String email;

    private Set<Dvd> rentedDvds = new LinkedHashSet<>();

    Customer(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    Set<Dvd> getRentedDvds() {
        return rentedDvds;
    }

    public String showRentedDvd() {
        if (rentedDvds.isEmpty()) {
            return "Brak";
        } else {
            StringBuilder dvds = new StringBuilder();
            for (Dvd dvd : rentedDvds) {
                dvds.append(dvd.getTitle()).append(", ");
            }
            dvds.deleteCharAt(dvds.length() - 1);
            dvds.deleteCharAt(dvds.length() - 1);
            return dvds.toString();
        }
    }
}
