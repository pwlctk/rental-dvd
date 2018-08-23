package pl.pwlctk;

import java.math.BigDecimal;

public class Dvd {
    private String title;
    private String genere;
    private int releaseDate;
    private BigDecimal rentalPrice;
    private BigDecimal salePrice;
    private boolean isCurrentlyRented;

    private Customer customer;

    Dvd(String title, String genere, int releaseDate) {
        this.title = title;
        this.genere = genere;
        this.releaseDate = releaseDate;

        this.isCurrentlyRented = false;
    }

    public void rent(Customer customer){
        this.customer = customer;
        this.isCurrentlyRented = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    boolean isCurrentlyRented() {
        return isCurrentlyRented;
    }

    public Customer getCustomer() {
        return customer;
    }
}
