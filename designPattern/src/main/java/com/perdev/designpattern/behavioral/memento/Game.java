package com.perdev.designpattern.behavioral.memento;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.memento
 * Date       2021/07/12 - 09:56
 * Author     Payne.
 * About      类描述：
 */
public class Game {
    private int coin = 0;
    private int level = 1;

    @Override
    public String toString() {
        return "Game{" +
                "coin=" + coin +
                ", level=" + level +
                '}';
    }

    public void play() {
        System.out.println("打野。。。");
        level++;
        System.out.println("等级提升了，当前等级=" + level);
        coin += 22;
        System.out.println("获得金币22，当前金币=" + coin);
    }

    public void exit() {
        System.out.println("退出游戏，游戏属性=" + toString());
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.coin = coin;
        memento.level = level;
        return memento;
    }

    public void setMemento(Memento memento) {
        level = memento.level;
        coin = memento.coin;
        System.out.println("读取存档信息：" + toString());
    }
}