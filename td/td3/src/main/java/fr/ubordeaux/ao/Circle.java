package fr.ubordeaux.ao;

public class Circle extends Ellipse{

    public Circle(Point2D center, int radius,Style style) {
        super(center, radius, radius, style);
    }

    public String toSVG(){
        return "<circle cx=\""+this.center.getX()+"\" cy=\""+this.center.getY()+"\" r=\""+this.radiusX+"\"/>";
    }
    
    
}