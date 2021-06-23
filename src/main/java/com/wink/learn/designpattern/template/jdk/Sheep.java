package com.wink.learn.designpattern.template.jdk;

/**
 * description: Sheep <br>
 * date: 2021/6/8 下午2:51 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Sheep implements Comparable<Sheep> {

    private String name;
    private int weight;

    public Sheep() {
    }

    public Sheep(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Sheep o) {
        //asc
//        return Integer.compare(this.weight, o.weight);
        //desc
        return Integer.compare(o.weight, this.weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
