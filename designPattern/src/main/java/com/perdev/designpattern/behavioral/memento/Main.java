package com.perdev.designpattern.behavioral.memento;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.behavioral.memento
 * Date       2021/07/12 - 09:53
 * Author     Payne.
 * About      类描述：
 */
public class Main {
    public static void main() {
        System.out.println("第一次进入游戏");
        Game game = new Game();
        game.play();
        Memento memento = game.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);
        game.exit();

        System.out.println("_________---------________");
        System.out.println("第二次进入游戏");
        Game game2 = new Game();
        System.out.println("游戏属性：" + game2.toString());
        game2.setMemento(caretaker.getMemento());
        System.out.println("游戏属性：" + game2.toString());
        game2.play();
        System.out.println("游戏属性：" + game2.toString());
        game2.exit();

    }
}