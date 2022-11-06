package com.example.demo.flowers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/api/vi/flowerbucket")
public class FlowerBucketController {
    @GetMapping
    public List<Flower> getFlowerBuckets(){
        return Arrays.asList(new Flower("NEW COLOUR", 50, 333), new Flower("black", 50, 333), new Flower("Blue", 50, 333));
    }

}