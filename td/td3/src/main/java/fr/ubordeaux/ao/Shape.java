package fr.ubordeaux.ao;

public abstract class  Shape {
    protected Style style;
    //TODO: add style to modify color, stroke... 
    public Shape(Style style){
        this.style = style;
    }
    public abstract String toSVG();
}