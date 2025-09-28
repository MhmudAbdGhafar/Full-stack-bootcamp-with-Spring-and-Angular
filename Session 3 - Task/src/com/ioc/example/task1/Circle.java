package com.ioc.example.task1;

public class Circle implements Shape {

    private Draw2dShape draw2dShape;

    private Draw3dShape draw3dShape;

    public Circle(Draw2dShape draw2dShape,  Draw3dShape draw3dShape) {
        this.draw2dShape = draw2dShape;
        this.draw3dShape = draw3dShape;
    }

    @Override
    public void draw2D() {
        draw2dShape.draw(getShapeName());
    }

    @Override
    public void draw3d() {
        draw3dShape.draw(getShapeName());
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}