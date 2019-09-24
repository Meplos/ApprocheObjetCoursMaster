package fr.ubordeaux.ao;

public class Rectangle extends Shape {
    Point2D o;
    int width;
    int height;

    public Rectangle(Point2D o, int width, int height) {
        this.o = o;
        this.width = width;
        this.height = height;
    }

    public String toSVG(){
        return "<rect x=\""+this.o.getX()+"\" y=\""+this.o.getY()+"\" width=\""+this.width+"\" height=\""+this.height+"\"/>";
    }
}