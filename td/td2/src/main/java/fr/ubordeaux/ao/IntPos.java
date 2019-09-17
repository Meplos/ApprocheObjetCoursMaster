package fr.ubordeaux.ao;

class IntPos{
    private int value;

    public IntPos( int v) throws IllegalArgumentException {
        set(v);
    }

    public void set(int v){
        if (v > 0) {
            this.value = v;
        } else {
            throw new IllegalArgumentException("v must be positive and not null");
        }
    }
    
    public int value(){
        return this.value;
    }
}