package fr.ubordeaux.ao;

public class Style {
    private String stroke;
    private int stroke_width;
    private String fill;

    public Style(String stroke, int stroke_width, String fill) {
        this.stroke = stroke;
        this.stroke_width = stroke_width;
        this.fill = fill;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public int getStroke_width() {
        return stroke_width;
    }

    public void setStroke_width(int stroke_width) {
        this.stroke_width = stroke_width;
    }

    public String getfill() {
        return fill;
    }

    public void setfill(String fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "style=\"stroke:" + stroke + "; stroke_width:" + stroke_width + "; fill:" + fill + "\"";
    }

    

    
}