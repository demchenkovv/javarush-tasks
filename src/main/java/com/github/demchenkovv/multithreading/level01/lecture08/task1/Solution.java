package com.github.demchenkovv.multithreading.level01.lecture08.task1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users == clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }


//    public Object clone() throws CloneNotSupportedException {
//        Solution o = (Solution) super.clone();
//
//        //clone users
//        Map<String, User> newUsers = new LinkedHashMap<>();
//        for (String key : o.users.keySet()) {
//            User user = o.users.get(key);
//            newUsers.put(key, (User) user.clone());
//        }
//        o.users = newUsers;
//
//        return o;
//    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution cloneSolution = (Solution) super.clone();

        Map<String, User> cloneUsers = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User user = entry.getValue();
            String k = entry.getKey();
            User v = new User(user.age, user.name);
            cloneUsers.put(k, v);
        }
        cloneSolution.users = cloneUsers;
        return cloneSolution;
    }
}
