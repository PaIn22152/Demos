package com.perdev.designpattern.structural.composite;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.composite
 * Date       2021/06/16 - 10:42
 * Author     Payne.
 * About      类描述：
 * 二叉树是最简单的组合模式
 */
public class ListNode {
    public int value;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode left;
    public ListNode right;
}