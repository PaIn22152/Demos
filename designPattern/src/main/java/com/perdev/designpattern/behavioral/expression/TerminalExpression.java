package com.perdev.designpattern.behavioral.expression;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.expression
 * Date       2021/06/30 - 11:51
 * Author     Payne.
 * About      类描述：
 */
public class TerminalExpression implements Expression {

    String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}