package org.youjhin.gbspringhw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    //использовал Autowired без final и конструктора (sonarLint ругается, лучше с конструктором)

    @Autowired
    private UserService userService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private NotificationService notificationService;


    public User registrationUser(String name, int age, String email) {

        User user = userService.createUser(name, age, email);
        dataProcessingService.addUser(user);
        notificationService.notifyRegisterUser(user);

        return user;

    }
}
