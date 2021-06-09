package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sensor")
public class SenserController {

    @GetMapping("all")
    public Map get() {
        return SenserData.get();
    }

    @GetMapping("history/{name}")
    public List getHistory(@PathVariable("name") String name) {
        return SenserData.history(name);
    }
}
