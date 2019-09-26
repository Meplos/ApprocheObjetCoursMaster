package fr.ubordeaux.ao;

import java.util.Objects;

/**La classe est muable */
public class Address {
    private int number;
    private String street;
    private Town town;

    public Address(int number, String street, Town town) {
        this.number = number;
        this.street = street;
        this.town = town;
    }

    public int getNumber() { //ne change pas
        return number;
    }

    public String getStreet() { //ne change pas
        return street;
    }

    public Town getTown() { //ne change pas
        return town;
    }

    @Override
    public boolean equals(Object other) { // depend
        if (! (other instanceof Address)) return false;
        Address otherAddress = (Address) other;
        boolean sameNumber = this.number == otherAddress.getNumber();
        boolean sameStreet = this.street.compareTo(otherAddress.getStreet()) == 0;
        boolean sameTown = this.town.equals(otherAddress.getTown());
        return  sameNumber && sameStreet && sameTown;
    }

    @Override
    public int hashCode() { //depend
        return Objects.hash(number, street, town);
    }

    @Override
    public String toString() { // ne change pas
        return number+" "+street+" "+town.toString();
    }

}