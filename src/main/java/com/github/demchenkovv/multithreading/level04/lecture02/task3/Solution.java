package com.github.demchenkovv.multithreading.level04.lecture02.task3;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
Так-с... сопоставим
*/

public class Solution {
    public static class A implements Serializable {
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }

    }

    public static class B implements Remote {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }

//    protected Thread clone() throws CloneNotSupportedException {
//        return (Thread) super.clone();
//    }
//
//    protected ArrayDeque clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * При попытке клонировать все вложенные классы (кроме класса C)
     * получим исключение CloneNotSupportedException, так как ни один из
     * них не реализует интерфейс Cloneable.
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // Код для тестирования

//        Solution.A a = new Solution.A();
//        Solution.A cloneA = a.clone();

//        Solution.B b = new Solution.B();
//        Solution.B cloneB = b.clone();

//        Solution.C c = new Solution.C();
//        Solution.C cloneC = c.clone();

//        Solution.D d = new Solution.D();
//        Solution.D cloneD = d.clone();
    }
}
