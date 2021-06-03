package com.perdev.designpattern.factory;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.factory
 * Date       2021/06/03 - 16:38
 * Author     Payne.
 * About      类描述：
 */
public class ShapeFactory {
    public static final int SHAPE_CIRCLE = 0;
    public static final int SHAPE_SQUARE = 1;

    public static Shape getShape(int shapeType) {
        if (SHAPE_CIRCLE == shapeType) {
            return new Circle();
        } else if (SHAPE_SQUARE == shapeType) {
            return new Square();
        }
        return null;
    }
}
