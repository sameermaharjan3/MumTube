package org.mumyoutube.config;


import org.springframework.web.server.session.WebSessionManager;

public class AppConfig {

    private static String id = "";

    public static void setId(String name) {
        id = name;
    }

    public static String getId() {

        return id;
    }

}
