package fr.ubordeaux.ao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

public class SVG {
    private int width;
    private int heigth;
    private HashSet<Shape> shapes;
    public SVG(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        this.shapes = new HashSet<Shape>();
    }

    public void add(Shape shape){
        this.shapes.add(shape);
    }

    public void save(String filename) throws IOException{
        String start = "<?xml version=\"1.0\" standalone=\"no\"?> <svg width=\""+this.width+"\" height=\""+this.heigth+"\" xmlns=\"http://www.w3.org/2000/svg\">";
        String end = "</svg>";
        FileOutputStream outputStream = new FileOutputStream(filename);
        byte[] svgByteArray = start.getBytes();
        outputStream.write(svgByteArray);

        for (Shape shape : shapes) {
            svgByteArray = shape.toSVG().getBytes();
            outputStream.write(svgByteArray); 
        }

        svgByteArray = end.getBytes();
        outputStream.write(svgByteArray);

        outputStream.close();
    }
}