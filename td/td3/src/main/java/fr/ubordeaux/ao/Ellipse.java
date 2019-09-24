package fr.ubordeaux.ao;

public class Ellipse extends Shape {
    Point2D center; 
    int radiusX;
    int radiusY;

    public Ellipse(Point2D center, int radiusX, int radiusY) {
        super();
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSVG() {
        return "<ellipse cx=\""+this.center.getX()+"\" cy=\""+this.center.getY()+"\" rx=\""+this.radiusX+"\" ry=\""+this.radiusY+"\"/>";
    }


    


    
    
}