package com.ioc.example.task1;

public class Square implements Shape {

    private Draw2dShape draw2dShape;

    private Draw3dShape draw3dShape;

    public void setDraw2dShape(Draw2dShape draw2dShape) {
        this.draw2dShape = draw2dShape;
    }

    public void setDraw3dShape(Draw3dShape draw3dShape) {
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
        return "Square";
    }
}
