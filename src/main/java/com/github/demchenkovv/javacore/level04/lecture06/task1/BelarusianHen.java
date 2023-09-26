package com.github.demchenkovv.javacore.level04.lecture06.task1;

public class BelarusianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
               String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                       Country.BELARUS,
                       this.getCountOfEggsPerMonth());
    }
}
