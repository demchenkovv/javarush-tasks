package com.github.demchenkovv.multithreading.level04.lecture06.task2;

import java.util.List;

/* 
Как избежать Copy+Paste
*/

public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
