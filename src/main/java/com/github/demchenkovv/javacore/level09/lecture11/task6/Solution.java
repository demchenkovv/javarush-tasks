package com.github.demchenkovv.javacore.level09.lecture11.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        args = new String[]{"C:\\Users\\HOME\\IdeaProjects\\JavaRush\\lectures\\src\\main\\java\\com\\github\\demchenkovv\\javacore\\level09\\lecture11\\task6\\input.txt"};

        Pattern pattern = Pattern.compile("^([А-Яа-я -]+) (\\d.+)"); // group(1) - name, group(2) - bd
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String s = reader.readLine();
                Matcher matcher = pattern.matcher(s);
                String name = "";
                String bd = "";
                while (matcher.find()) {
                    name = matcher.group(1);
                    bd = matcher.group(2);
                }
                Date birthdate = dateFormat.parse(bd);
                PEOPLE.add(new Person(name, birthdate));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
