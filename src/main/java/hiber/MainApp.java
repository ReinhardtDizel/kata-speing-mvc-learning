package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car vaz = new Car(219010, "LADA");
        Car bmw = new Car(2, "BMW");
        Car taz = new Car(100500, "TAZ");

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", vaz));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", taz));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", bmw));

        List<User> users = userService.listUsers();

        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        User userVaz = userService.getUserByCar(vaz);
        User userBmw = userService.getUserByCar(bmw);
        User userTaz = userService.getUserByCar(taz);

        System.out.println();
        System.out.println("LADA у " + userVaz.getFirstName());
        System.out.println("BMW у " + userBmw.getFirstName());
        System.out.println("TAZ у " + userTaz.getFirstName());

        context.close();
    }
}
