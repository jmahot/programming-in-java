package agh.ii.prinjava.lab04.exc04_01;

public class Pair<F, S> implements Cloneable {
    private F first;
    private S second;

    public Pair(F fst, S snd) {
        this.first = fst;
        this.second = snd;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair<?, ?> otherPair = (Pair<?, ?>) obj;
        return first.equals(otherPair.first) && second.equals(otherPair.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }

    @Override
    public Pair<F, S> clone() {
        try {
            @SuppressWarnings("unchecked")
            Pair<F, S> clonedPair = (Pair<F, S>) super.clone();
            return clonedPair;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
