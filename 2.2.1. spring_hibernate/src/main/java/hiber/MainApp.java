package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car lada = new Car("Lada", 2107);
        Car bmw = new Car("BMW", 34);
        Car audi = new Car("Audi", 6);
        Car maybach = new Car("maybach", 600);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", lada));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", bmw));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", audi));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", maybach));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model " + user.getCarUser().getModel());
            System.out.println("Series " + user.getCarUser().getSeries());
            System.out.println(user.getCarUser());
            System.out.println("----------------");
        }
//        List<User> carUser = userService.getUsersByCar("BMW", 34);  -- получение списка сущностей
        User user = userService.getUserByCar("BMW", 34);
        System.out.println(user);

        // Я не понял ТЗ в плане нужно получать список обьектов или сам обьект
        // и сделал получение через коллекцию и саму сущность

        context.close();
    }
}
