package com.sourabh.Restful_web_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {


    private static List<user> users =new ArrayList<user>();
    private static int count=0;
    static {
        users.add(new user("sourabh",++count, LocalDate.now().minusYears(24)));
        users.add(new user("vishal",++count, LocalDate.now().minusYears(30)));
        users.add(new user("ankush",++count, LocalDate.now().minusYears(40)));

    }

    public  List<user> getUsers() {
        return users;
    }

    public  user getUserById(int id) {
        Predicate<? super user> predicate= user ->user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public  void DeleteUserById(int id) {
      user user=  this.getUserById(id);
      users.remove(user);

    }


    public user saveUser(user user){
        user.setId(++count);
        users.add(user);
        return user;
    }

}
