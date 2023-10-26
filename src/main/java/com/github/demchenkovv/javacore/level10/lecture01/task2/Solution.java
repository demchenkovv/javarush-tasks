package com.github.demchenkovv.javacore.level10.lecture01.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String yourFile = "src/main/java/com/github/demchenkovv/javacore/level10/lecture01/task2/data.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new Date(System.currentTimeMillis()));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user2 = new User();
            user2.setFirstName("Denis");
            user2.setLastName("Denisenko");
            user2.setBirthDate(new Date(System.currentTimeMillis()));
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);

            User user3 = new User();
            user3.setFirstName("Ingrid");
            user3.setLastName("De Fantomas");
            user3.setBirthDate(new Date(System.currentTimeMillis()));
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);

            javaRush.users.addAll(Arrays.asList(user1, user2, user3));

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            try (PrintStream printStream = new PrintStream(outputStream)) {
                if (this.users.size() == 0) {
                    return;
                }
                for (User user : this.users) {
                    printStream.println(user.getFirstName());
                    printStream.println(user.getLastName());
                    printStream.println(user.getBirthDate().getTime());
                    printStream.println(user.isMale());
                    printStream.println(user.getCountry().getDisplayName());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream))) {
                while (fileReader.ready()) {
                    String firstName = fileReader.readLine();
                    String lastName = fileReader.readLine();
                    Date bd = new Date(Long.parseLong(fileReader.readLine()));
                    boolean male = fileReader.readLine().equals("true");
                    String countryLine = fileReader.readLine();
                    User.Country country = switch (countryLine) {
                        case "Russia" -> User.Country.RUSSIA;
                        case "Ukraine" -> User.Country.UKRAINE;
                        default -> User.Country.OTHER;
                    };
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(bd);
                    user.setMale(male);
                    user.setCountry(country);
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

// Решение JR
//         public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            if (this.users.size() > 0) {
//                for (User current : this.users) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(current.getFirstName());
//                    sb.append("/");
//                    sb.append(current.getLastName());
//                    sb.append("/");
//                    sb.append(current.getBirthDate().getTime());
//                    sb.append("/");
//                    sb.append(current.isMale());
//                    sb.append("/");
//                    sb.append(current.getCountry());
//
//                    printWriter.println(sb.toString());
//                }
//            }
//            printWriter.close();
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                User user = new User();
//                String[] lineArray = line.split("/");
//                if (lineArray.length < 5) {
//                    break;
//                }
//                user.setFirstName(lineArray[0]);
//                user.setLastName(lineArray[1]);
//                user.setBirthDate(new Date(Long.parseLong(lineArray[2])));
//                user.setMale(Boolean.parseBoolean(lineArray[3]));
//                switch (lineArray[4]) {
//                    case "UKRAINE":
//                        user.setCountry(User.Country.UKRAINE);
//                        break;
//                    case "RUSSIA":
//                        user.setCountry(User.Country.RUSSIA);
//                        break;
//                    default:
//                        user.setCountry(User.Country.OTHER);
//                        break;
//                }
//                this.users.add(user);
//            }
//
//            reader.close();
//        }