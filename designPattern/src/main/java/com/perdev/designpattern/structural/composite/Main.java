package com.perdev.designpattern.structural.composite;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.composite
 * Date       2021/06/16 - 10:43
 * Author     Payne.
 * About      类描述：
 */
public class Main {

    public static void main() {
        /*
         *   1
         *  / \
         * 2   3
         * */
        ListNode listNode = new ListNode(1);

        listNode.left = new ListNode(2);

        listNode.right = new ListNode(3);
    }
}