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
        // TODO Auto-generated method stub
        return "<ellipse cx=\""+this.center.getX()+"\" cy=\""+this.center.getY()+"\" rx=\""+this.radiusX+"\" ry=\""+this.radiusY+"\"/>";
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public int getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    


    
    
}