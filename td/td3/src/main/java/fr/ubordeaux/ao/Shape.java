package fr.ubordeaux.ao;

class Shape extends SVG{
    protected int x,y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Shape(int width, int heigth, int x, int y) {
        super(width, heigth);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return this.toString();
    }
    
}