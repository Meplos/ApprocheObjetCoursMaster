package fr.ubordeaux.ao.domain.type;

import java.lang.RuntimeException;

public class Description {

    final String value;

    public Description(String value) {
        if(value.length() <= 200){
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
        Description other = (Description) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    

    
}