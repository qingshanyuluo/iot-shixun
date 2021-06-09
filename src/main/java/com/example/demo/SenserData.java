package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class SenserData {

    private static ConcurrentHashMap<String, Senser> sensers = new ConcurrentHashMap<>();
    private static Random random = new Random();

    public static void init() {
        sensers.put("light", new Senser("light", "尼特"));
        sensers.put("temperature", new Senser("temperature", "摄氏度"));
        sensers.put("humidity", new Senser("humidity", "%"));

        new ScheduledThreadPoolExecutor(2).scheduleAtFixedRate(() -> {
            sensers.get("light").record();
            sensers.get("light").setData(random.nextInt(2000));
            sensers.get("temperature").record();
            sensers.get("temperature").setData(random.nextInt(42));
            sensers.get("humidity").record();
            sensers.get("humidity").setData(random.nextInt(100));

        }, 0, 4, TimeUnit.SECONDS);
    }

    public static Map<String, Senser> get() {
        return sensers;
    }

    public static List<Double> history(String name) {
        return sensers.get(name).history();
    }


}
