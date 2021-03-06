package com.perdev.designpattern.creational.factory;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.creational.factory
 * Date       2021/06/03 - 16:38
 * Author     Payne.
 * About      类描述：
 */
public class ShapeFactory {
    public static final int SHAPE_CIRCLE = 0;
    public static final int SHAPE_SQUARE = 1;

    @IntDef(value = {SHAPE_CIRCLE, SHAPE_SQUARE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ShapeType {
    }

    public static Shape getShape(@ShapeType int shapeType) {
        if (SHAPE_CIRCLE == shapeType) {
            return new Circle();
        } else if (SHAPE_SQUARE == shapeType) {
            return new Square();
        }
        return null;
    }
}
