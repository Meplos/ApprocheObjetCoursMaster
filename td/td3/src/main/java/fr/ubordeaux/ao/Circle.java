package fr.ubordeaux.ao;

public class Circle extends Ellipse{

    public Circle(Point2D center, int radius) {
        super(center, radius, radius);
    }

    public String toSVG(){
        return "<circle cx=\""+this.center.getX()+"\" cy=\""+this.center.getY()+"\" r=\""+this.radiusX+"\"/>";
    }
    
    
}