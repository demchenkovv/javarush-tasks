package com.github.demchenkovv.multithreading.level01.lecture05.task1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Solution other = (Solution) o;
        boolean firstCodeEquals = (this.first == null && other.first == null) || (this.first != null && this.first.equals(other.first));
        boolean lastCodeEquals = (this.last == null && other.last == null) || (this.last != null && this.last.equals(other.last));
        return firstCodeEquals && lastCodeEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Solution solution = (Solution) o;
//
//        if (!Objects.equals(first, solution.first)) return false;
//        return Objects.equals(last, solution.last);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = first != null ? first.hashCode() : 0;
//        result = 31 * result + (last != null ? last.hashCode() : 0);
//        return result;
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

}
