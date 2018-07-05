package net.youareatman.helpers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class YouAreAtmanHelpers {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String password){
        return passwordEncoder.encode(password);
    }

}
