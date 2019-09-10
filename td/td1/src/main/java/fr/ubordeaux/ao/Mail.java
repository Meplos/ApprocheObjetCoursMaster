package fr.ubordeaux.ao;

import java.util.Objects;

/**La classe est immuable */
public class Mail {
    private String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() { // ne change pas
        return mail;
    }

    @Override
    public boolean equals(Object other) { //depend
        if (! (other instanceof Mail)) return false;
        Mail otherMail = (Mail) other;
        return  this.mail.compareTo(otherMail.getMail())==0;
    }

    @Override
    public int hashCode() { //depend
        return Objects.hash(mail);
    }

    @Override
    public String toString() { //ne change pas
        return "mails: "+mail;
    }

}