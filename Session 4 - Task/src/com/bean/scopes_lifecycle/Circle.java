package com.bean.scopes_lifecycle;

public class Circle implements Shape {

    private double radius;

    private double area;

    private Draw2DShape draw2DShape;

    private Draw3DShape draw3DShape;

    public Circle(Draw2DShape draw2DShape, Draw3DShape draw3DShape){
        this.draw2DShape = draw2DShape;
        this.draw3DShape = draw3DShape;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void getArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    public void draw2DShape(){
        this.draw2DShape.draw(getShapeName());
    }

    public void draw3DShape(){
        this.draw3DShape.draw(getShapeName());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + area +
                '}';
    }
}