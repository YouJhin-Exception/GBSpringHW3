package org.youjhin.gbspringhw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository userRepository;


   public void addUser(User user){
       userRepository.save(user);
   }

   public List<User> getAllUsersFromBase(){
       return (List<User>) userRepository.findAll();
   }

    public String getGreeting() {
        return "Hello world!";
    }

    public List<User> sortUserByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();
    }

    public List<User> filterUserByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .toList();
    }

    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
