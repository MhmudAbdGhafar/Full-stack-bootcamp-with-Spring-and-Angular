package com.bean.scopes_lifecycle;

public class Rectangle implements Shape {

    private double width;

    private double height;

    private double area;

    private Draw2DShape draw2DShape;

    private Draw3DShape draw3DShape;

    public void setDraw2DShape(Draw2DShape draw2DShape) {
        this.draw2DShape = draw2DShape;
    }

    public void setDraw3DShape(Draw3DShape draw3DShape) {
        this.draw3DShape = draw3DShape;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void getArea() {
        area = width * height;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    public void draw2DShape(){
        draw2DShape.draw(getShapeName());
    }

    public void draw3DShape(){
        draw3DShape.draw(getShapeName());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + area +
                '}';
    }
}