package com.example.UserTP.controllers;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/show")
public class ThymeleafController {

    @Autowired
    UserServices uService;

    @Autowired
    CommandServices cService;

    @Autowired
    PaymentServices pService;

     // 2.5. GET  /getArticles/{idCommande} -> Envoie tout les articles de la commande à l'ID {idCommande}
     @GetMapping("/articlesId/{id}")
     public String showArticleByCommandId(Model model, @PathVariable int id){
         List<Article> articles = cService.getArticleByCommandId(id);
         model.addAttribute("articles", articles);
         return "articlesId";
     }

     
     //
     @GetMapping("/show/{debut}/{fin}")
    public String showBycommandDateBetween( Model model,
        @PathVariable("debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut,
        @PathVariable("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
             List<Command> commands = cService.getCommandByDates(debut, fin);
             List<User> users = commands.stream().map(Command::getUser).toList();
             //List<CommandLine> commandLines = commands.stream().map(Command::getCommandLines).flatMap(List::stream).toList();
             model.addAttribute("commands", commands);
             model.addAttribute("users", users);
        return "debutfin" ;
    }

    
    @GetMapping("/articles")
    public String showAllArticles(Model model) {
    List<Article> articles = cService.getAllArticles();
    model.addAttribute("articles", articles);
     return "articles";
    }


    @GetMapping("/commands")
    public String showAllCommands(Model model) {
    List<Command> commands = cService.getAllCommands();
    List<User> users = uService.getAllUsers();
    List<Article> articles = cService.getAllArticles();
    List<CommandLine> commandLines = cService.getAllCL();
    List<Paypal> paypal = pService.getAllPaypal();
    model.addAttribute("users", users);
    model.addAttribute("commands", commands); //i
    model.addAttribute("commandLines", commandLines);//j
    model.addAttribute("articles", articles);//k
    model.addAttribute("payments", paypal);//l
     return "commands";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
    List<User> users = uService.getAllUsers();
    List<Info> infos = uService.getAllInfo();
    List<Role> roles = uService.getAllRole();
    model.addAttribute("users", users);
    model.addAttribute("infos", infos);
    model.addAttribute("roles", roles);
     return "users";
    }

    
}
