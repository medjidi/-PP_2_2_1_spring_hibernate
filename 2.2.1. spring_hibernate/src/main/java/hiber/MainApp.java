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

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car = new Car("Audi", 8);
      user1.setCar(car);
      userService.add(user1);
      System.out.println("1");

      User user2 = new User("Balbes", "Myasnitski", "balbesik@gmail.com");
      user2.setCar(new Car("Bently", 1000));
      System.out.println("2");


      userService.add(user2);
      System.out.println("3");

      User user3 = new User("Abulbas", "Tigrulatov", "tiger@gmail.com");
      user3.setCar(new Car("Mercedes", 10));
      System.out.println("4");

      userService.add(user3);
      System.out.println("5");

      User user4 = new User("Rasiel", "Weapon", "poluchaiRasiel@gmail.com");
      user4.setCar(new Car("Lada Granta Sport", 0));
      System.out.println("1");

      userService.add(user4);
      System.out.println("1");

      User oldUser = userService.getUserByCar("Mercedes",10);

      System.out.println(oldUser.getFirstName());

      List<User> users = userService.getListUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar()!=null){
            System.out.println("Car Id = " + user.getCar().getId());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
         }
         System.out.println();
      }
      context.close();
   }
}
