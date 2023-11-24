package com.github.demchenkovv.multithreading.level05.lecture02.task2503;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        // [-1, 2, 1, 0]
        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i] != -1) {
                result.add(Column.values()[i]);
            }
        }
        // result.sort(Comparator.comparingInt(o -> realOrder[o.ordinal()]));
        // развернутая версия кода выше:
        result.sort(new Comparator<Column>() {
            @Override
            public int compare(Column o1, Column o2) {
                return Integer.compare(realOrder[o1.ordinal()], realOrder[o2.ordinal()]);
            }
        });
        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder != null && realOrder[ordinal()] != -1;
    }

    @Override
    public void hide() {
        int oldOrder = realOrder[ordinal()];
        if (oldOrder == -1) return; //already hidden
        realOrder[ordinal()] = -1;
        //reorder
        for (int i = 0; i < realOrder.length; i++) {
            int currentIndex = realOrder[i];
            if (currentIndex != -1 && currentIndex > oldOrder) {
                realOrder[i] -= 1;
            }
        }
    }
}
