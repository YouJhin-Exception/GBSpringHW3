package org.youjhin.gbspringhw3;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());
    }

    public void notifyRegisterUser(User user){
        System.out.println("A new user has been registration: " + user.getName());
    }
}
