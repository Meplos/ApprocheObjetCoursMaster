package fr.ubordeaux.ao.domain.type;

import java.lang.RuntimeException;

public class Name {

    final String value;

    public Name(String value) {
        if(value.length() <= 20){
            this.value = value;
        } else {
            throw new RuntumeException();
        }
    }

    
}