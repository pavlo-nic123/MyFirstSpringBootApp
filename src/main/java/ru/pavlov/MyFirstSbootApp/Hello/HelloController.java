package ru.pavlov.MyFirstSbootApp.Hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private List<String> list = null;

    private Map<Integer, String> map = null;

    private int mapCounter = 1;

    @GetMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue = "World") String name) {
        return String.format("Hello %s !", name);
    }

    @GetMapping("/update-array")
    public List<String> updateArrayList(@RequestParam String s) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(s);
        return list;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    @GetMapping("/update-map")
    public Map<Integer, String> updateHashMap(@RequestParam String s) {
        if (map == null) {
            map = new HashMap<>();
            mapCounter = 1;
        }
        map.put(mapCounter++, s);
        return map;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        if (map == null) {
            return new HashMap<>();
        }
        return map;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int listSize = (list != null) ? list.size() : 0;
        int mapSize = (map != null) ? map.size() : 0;
        return String.format("ArrayList size: %d, HashMap size: %d", listSize, mapSize);
    }
}
