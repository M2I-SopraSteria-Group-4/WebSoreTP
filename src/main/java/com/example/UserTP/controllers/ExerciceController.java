package com.example.UserTP.controllers;
import org.springframework.web.bind.annotation.*;
import com.example.UserTP.services.*;

@RestController
@RequestMapping("/exercice")
public class ExerciceController{

    @GetMapping("/reverse/{q}")
    public String getCommand(@PathVariable String q){
        return ExerciceServices.reverseStringLetter(q);
    }

    @GetMapping("/rwx/{q}")
    public int SumLetter(@PathVariable String q){
        return ExerciceServices.SumLetter(q);
    }

    @GetMapping("/duel/{hp1}/{hp2}/{d1}/{d2}")
    public String duel(@PathVariable int hp1,@PathVariable int hp2,@PathVariable int d1,@PathVariable  int d2){
        return ExerciceServices.duel(hp1,hp2,d1,d2);
    }

    @GetMapping("/bird")
    public String BirdTalk(@RequestParam String q){
        return ExerciceServices.BirdTalk(q);
    }

    @GetMapping("/acgt")
    public String ACGT(@RequestParam String q){
        return ExerciceServices.ADN(q);
    }

    @GetMapping("/triangle")
    public Double Round(@RequestParam double q){
        return ExerciceServices.Round(q);
    }
}