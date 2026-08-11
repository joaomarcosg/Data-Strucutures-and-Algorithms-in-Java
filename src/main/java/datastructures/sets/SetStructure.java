package main.java.datastructures.sets;

import java.util.HashSet;
import java.util.Set;

public class SetStructure<T> {

    private final Set<T> set = new HashSet<>();

    public boolean has(T element) {
        return set.contains(element);
    }

    public boolean add(T element) {
        return set.add(element);
    }

    public boolean delete(T element) {
        return set.remove(element);
    }

    public void clear() {
        set.clear();
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public Set<T> values() {
        return new HashSet<>(this.set);
    }

    public SetStructure<T> union(SetStructure<T> otherSet) {
        SetStructure<T> unionSet = new SetStructure<>();

        unionSet.set.addAll(this.set);
        unionSet.set.addAll(otherSet.set);

        return unionSet;
    }

    public SetStructure<T> intersection(SetStructure<T> otherSet) {
        SetStructure<T> intersectionSet = new SetStructure<>();

        Set<T> biggerSet = this.values();
        Set<T> smallerSet = otherSet.values();

        if (otherSet.size() > this.size()) {
            biggerSet = otherSet.values();
            smallerSet = this.values();
        }

        Set<T> finalBiggerSet = biggerSet;
        smallerSet.forEach(e -> {
            if (finalBiggerSet.contains(e)) {
                intersectionSet.add(e);
            }
        });

        return intersectionSet;
    }

    public SetStructure<T> difference(SetStructure<T> otherSet) {
        SetStructure<T> differenceSet = new SetStructure<>();

        this.set.forEach(e -> {
            if (!otherSet.has(e)) {
                differenceSet.add(e);
            }
        });

        return differenceSet;
    }

    public boolean isSubsetOf(SetStructure<T> otherSet) {
        if (this.size() > otherSet.size()) return false;

        return this.set.stream().allMatch(otherSet::has);
    }
}
