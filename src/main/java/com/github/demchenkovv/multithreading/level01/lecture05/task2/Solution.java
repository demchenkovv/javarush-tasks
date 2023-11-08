package com.github.demchenkovv.multithreading.level01.lecture05.task2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
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

//        // Валидатор принимает только через instanceof
//        if (!(o instanceof Solution)) {
//            return false;
//        }

        Solution n = (Solution) o;
        if (!Objects.equals(first, n.first)) {
            return false;
        }
        return Objects.equals(last, n.last);
    }

    @Override
    public final int hashCode() {
        int result = 17;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
