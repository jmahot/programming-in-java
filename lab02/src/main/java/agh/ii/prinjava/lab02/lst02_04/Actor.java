package agh.ii.prinjava.lab02.lst02_04;

public record Actor(String name, String surname) {
    @Override
    public String toString() {
        return name + " " + surname;
    }
}