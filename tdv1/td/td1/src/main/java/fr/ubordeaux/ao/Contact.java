package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**la classe est muable */
public class Contact {
    private static int nextId=1;
    private int id;
    private String firstName;
    private String secondName;
    private Address address;
    private Set<Mail> mails;
    private Set<PhoneNumber> phones;


    public Contact(String firstName, String secondName, Address address) {
        this.id = Contact.nextId++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        mails = new HashSet<Mail>();
        phones = new HashSet<PhoneNumber>();
    }

    public int id() { // ne change pas
        return id;
    }

    public String getFirstName() { // ne change pas
        return firstName;
    }

    public String getSecondName() { // ne change pas
        return secondName;
    }

    public void changeAddress(Address newAddress) { //change
        this.address = newAddress;
    }

    public Address getAddress() { // ne change pas 
        return address;
    }

    public void addMail(Mail mail) { // change
        mails.add(mail);
    }

    public void removeMail(Mail mail) { // change
        mails.remove(mail);
    }

    public Set<Mail> getMails() { // ne change pas
        Set<Mail> mailz = new HashSet<Mail>();
        mailz.addAll(mails);
        return mailz;
    }

    public void addPhoneNumber(PhoneNumber phone) { //change
        phones.add(phone);
    }

    public void removePhoneNumber(PhoneNumber phone) { // change
        phones.remove(phone);
    }

    public Set<PhoneNumber> getPhoneNumbers() { // ne change pas
        Set<PhoneNumber> phonez = new HashSet<PhoneNumber>();
        phonez.addAll(phones);
        return phonez;
    }

    @Override
    public boolean equals(Object other) { // depend
        if (! (other instanceof Contact)) return false;
        Contact otherContact = (Contact) other;
        return  this.id == otherContact.id();
    }

    @Override
    public int hashCode() { // depend
        return Objects.hash(id);
    }

    @Override
    public String toString() { // ne change pas
        return "contact "+id;
    }
}