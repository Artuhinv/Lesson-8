import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<User>> usersMap = new HashMap<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя:");
            String name = in.nextLine();

            System.out.println("Введите возраст пользователя:");
            int age = in.nextInt();
            in.nextLine();

            User user = new User(name, age);
            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                usersMap.put(age, userList);
            }
        }

        System.out.println("Введите возраст, для которого нужно вывести список пользователей:");
        int ages = in.nextInt();
        in.nextLine();

        if (usersMap.containsKey(ages)) {
            List<User> userList = usersMap.get(ages);
            Collections.sort(userList, new Comparator<User>() {
                public int compare(User o1, User o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            System.out.println("Список пользователей с возрастом " + ages + ":");
            for (User user : userList) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Пользователей с возрастом " + ages + " не найдено.");
        }
    }
}
