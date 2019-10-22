package fr.ubordeaux.ao.domain.type;

public class PosInt {
    public final int value;

    public PosInt(int value) {
        if(value >= 0) {
            this.value = value;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
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
        PosInt other = (PosInt) obj;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PosInt [" + value + "]";
    }

    

    
    
}