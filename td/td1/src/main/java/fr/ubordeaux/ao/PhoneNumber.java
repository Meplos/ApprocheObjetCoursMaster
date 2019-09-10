package fr.ubordeaux.ao;

import java.util.Objects;

/**la classe est immuable */
public class PhoneNumber {
    private int number;

    public PhoneNumber(int number) {
        this.number = number;
    }

    public int getPhoneNumber() { //ne change pas
        return number;
    }

    @Override 
    public boolean equals(Object other) { //depend
        if (! (other instanceof PhoneNumber)) return false;
        PhoneNumber otherPhoneNumber = (PhoneNumber) other;
        return  number == otherPhoneNumber.getPhoneNumber();
    }

    @Override
    public int hashCode() { //depend
        return Objects.hash(number);
    }

    @Override
    public String toString() { // ne change pas
        return ""+number;
    }
}