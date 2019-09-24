package fr.ubordeaux.ao;

public class Line implements Shape.toSVG{
    private Point2D source;
    private Point2D target;
    public Line(Point2D source, Point2D target) {
        this.source = source;
        this.target = target;
    }

    public String toSVG(){
        return "";
    }
}