package com.example.demo;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserData {

    private static ConcurrentMap<String, String> users = new ConcurrentHashMap<>();

    public static boolean login(String username, String password) {
        return users.get(username).equals(password);
    }

    public static boolean register(String username, String password) {
        return users.putIfAbsent(username, password) == null;
    }

    public static Set<String> getAll() {
        return users.keySet();
    }

    public static void delete(String username) {
        users.remove(username);
    }
}
