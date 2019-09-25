package fr.ubordeaux.ao;

public class Line extends Shape{
    private Point2D source;
    private Point2D target;
    public Line(Point2D source, Point2D target, Style style) {
        super(style);
        this.source = source;
        this.target = target;
    }


    public String toSVG(){
        return "<line x1=\""+this.source.getX()+"\" y1=\""
            + this.source.getX()+"\" x2=\""+ this.target.getX()
            + "\" y2=\""+ this.target.getY()+"\" "+this.style+"/>";
    }
}