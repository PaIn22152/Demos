package com.perdev.designpattern.factory;

import android.arch.lifecycle.ViewModelProvider;
import android.text.Editable;
import android.text.Spannable;
import android.view.LayoutInflater;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.factory
 * Date       2021/06/03 - 16:37
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main(){
        Shape shape1 = ShapeFactory.getShape(ShapeFactory.SHAPE_CIRCLE);
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape(ShapeFactory.SHAPE_SQUARE);
        shape2.draw();



    }
}
