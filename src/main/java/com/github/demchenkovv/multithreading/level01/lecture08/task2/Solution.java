package com.github.demchenkovv.multithreading.level01.lecture08.task2;

/* 
Клонирование растений
*/

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);
        System.out.println(tree == clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
        System.out.println(tree.branches == clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Plant) super.clone();
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Tree(getName(), branches == null ? null : branches.clone());
        }

//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            Tree tree = (Tree) super.clone();
//            String[] branches = new String[tree.branches.length];
//            for (int i = 0; i < branches.length; i++) {
//                String s = tree.branches[i];
//                branches[i] = s;
//            }
//            tree.branches = branches;
//            return tree;
//        }
    }
}
