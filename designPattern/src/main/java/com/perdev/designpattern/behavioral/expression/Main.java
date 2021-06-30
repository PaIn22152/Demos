package com.perdev.designpattern.behavioral.expression;

import android.content.pm.PackageManager;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.expression
 * Date       2021/06/30 - 12:00
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    //规则：Robert 和 John 是男性
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //规则：Julie 是一个已婚的女性
    public static Expression getMarriedWomenExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main() {

        System.out.println("John is male:" + getMaleExpression().interpret("John"));
        System.out.println("Amy is male:" + getMaleExpression().interpret("Amy"));
        System.out.println("Amy is Married women:" + getMarriedWomenExpression().interpret("Amy"));
        System.out.println("Julie is Married women:" + getMarriedWomenExpression().interpret("Married Julie"));


    }
}