import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<Person> person = new LinkedList<>();
    public static Person client;

    public static void main(String[] args) {
        Queue<Person> queue = new ArrayDeque<>();
        generateClients();
        for (int i = 0; i < person.size(); i++) {
            queue.add(person.get(i));
        }

        while (!queue.isEmpty()) {
            client = queue.poll();
            System.out.println(client.getName() + " " + client.getSurname() + " прокатился на аттракционе.");
            client.setNumberOfTickets(client.getNumberOfTickets() - 1);
            if (client.getNumberOfTickets() > 0) {
                queue.offer(client);
            }
        }
    }

    public static List<Person> generateClients() {
        person.add(new Person("Петр", "Васильев", 2));
        person.add(new Person("Анна", "Кондрат", 1));
        person.add(new Person("Гарри", "Штольц", 2));
        person.add(new Person("Александр", "Пельш", 3));
        person.add(new Person("Мария", "Иванова", 5));
        return person;
    }
}