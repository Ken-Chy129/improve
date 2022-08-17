package com.example.rabbit_consumer;

import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Ken-Chy129
 * @date 2022/7/27 23:21
 */
public class Main {
    public static  void main(String[] args) {
        Main solution = new Main();
        Parent a = new Parent();
        Parent b = new Parent();
        Son c = new Son();
        Son d = new Son();
        Pair<? extends Parent> ancient = new Pair<>(a,b);
//        ancient.setFirst();
        Parent first = ancient.getFirst();
        Pair<? super Son> noGeneric = new Pair<>(c,d);
//        noGeneric.setFirst(c);
//        Son first2 = (Son) noGeneric.getFirst();
        Pair pair = new Pair<>(a, b);
        pair.setFirst(a);
    }
}   
class Parent{ }
class Son extends Parent{ }
class Pair<T>{
    T first;
    T second;
    public Pair(T first,T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public T getSecond() {
        return second;
    }
    public void setSecond(T second) {
        this.second = second;
    }
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
