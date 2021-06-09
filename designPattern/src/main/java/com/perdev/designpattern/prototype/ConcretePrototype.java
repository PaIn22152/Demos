package com.perdev.designpattern.prototype;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.prototype
 * Date       2021/06/09 - 10:30
 * Author     Payne.
 * About      类描述：
 */
public class ConcretePrototype implements Prototype {

    private String name;
    private boolean gender;

    public ConcretePrototype(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public Prototype myClone() {
        return new ConcretePrototype(name, gender);
    }
}