package fr.ubordeaux.ao.domain.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identifier{
     public final String value;

    public Identifier(String value) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*{20}");
        Matcher matcher = pattern.matcher(value);
        if(matcher.matches()) {
            this.value = value;
        
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Identifier other = (Identifier) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

        


}