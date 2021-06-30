package com.perdev.designpattern.behavioral.expression;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.expression
 * Date       2021/06/30 - 11:52
 * Author     Payne.
 * About      类描述：
 */
public class OrExpression implements Expression {

    Expression expression1;
    Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}