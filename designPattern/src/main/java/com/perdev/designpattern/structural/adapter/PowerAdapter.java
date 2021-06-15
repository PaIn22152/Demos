package com.perdev.designpattern.structural.adapter;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.adapter
 * Date       2021/06/15 - 16:18
 * Author     Payne.
 * About      类描述：
 */
public class PowerAdapter implements Input5v1a {
    final private Output220v output220v;

    public PowerAdapter(Output220v output220v) {
        this.output220v = output220v;
    }

    @Override
    public void in() {
        //把220v的输出电源转成5v1a的输入电源
        output220v.out();
        //return 5v1a
    }
}