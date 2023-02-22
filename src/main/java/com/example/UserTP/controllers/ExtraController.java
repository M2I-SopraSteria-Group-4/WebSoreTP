package com.example.UserTP.controllers;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.UserTP.entity.*;
import com.example.UserTP.services.*;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/extra")
public class ExtraController {

    @Autowired
    UserServices uService;

    @Autowired
    CommandServices cService;

    @Autowired
    PaymentServices pService;

    // 1. POST/Faker /newArticle?idCommande={id} -> Ajoute un article dans la comamnde {idCommande}
    @GetMapping("/newArticle/{id}")
    public CommandLine addArticleToId(@PathVariable int id){

        Faker faker = new Faker();
        Article article = cService.getRandomArticle();
        Command command = cService.getOneCommand(id);
        System.out.println("=========================================");
        System.out.println(article.getBrand()+article.getPrice()); 
        System.out.println("=========================================");
        

        int quantity = faker.number().randomDigitNotZero();

        CommandLine cLine = new CommandLine(quantity, command, article);     
        cService.createCL(cLine) ;

        return cLine;
    }

    // 2. GET  /getArticles/{idCommande} -> Envoie tout les articles de la commande à l'ID {idCommande}
    @GetMapping("/article/{id}")
    public List<Article> getArticleByCommandId(@PathVariable int id){
        return cService.getArticleByCommandId(id);
    }

   

    
    // 3. GET  /user/total/{idUser} -> Envoie le montant total payé par un utilisateur sur le site
    @GetMapping("/total/{id}")
    public double getTotal(@PathVariable int id){
        return pService.userPayments(id);
    }

     // 4. GET  /commande/ca {date_debut:"yyyy-mm-dd", date_fin:"yyyy-mm-dd"} 
     //-> Envoie la somme de toutes les commandes entre la date de début et date de fin
    @GetMapping("/ca/{debut}/{fin}")
    public List<Command> findBycommandDateBetween(
        @PathVariable("debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut,
        @PathVariable("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
    return cService.getCommandByDates(debut, fin);
    }

    
    // 5. GET  /article?brand={marque} -> Envoie tout les article de la {marque}
    @GetMapping("/articleBrand/{brand}")
    public List<Article> getArticleByBrand(@PathVariable String brand){
        return cService.getArticleByBrand(brand);
    }


    // 6. POST /article/list -> Ajoute une liste d'articles entière en une seule requete
    @PostMapping("/articlelist")
    public void addArticleList(@RequestBody List<Article> articles){
        cService.createArticleList(articles);
    }

    // 7. GET  /user?city={ville} -> Envoie tout les utilisateurs d'une {ville}
    @GetMapping("/city/{city}")
    public List<User> getUsersByCity(@PathVariable String city){
        return uService.getUserByCity(city);
    }

     // 8. GET  /user/?city={ville}&duree={date} -> Envoie tout les utilisateurs d'une {ville} ayant commandé il y a moins de {date}
    @GetMapping("/datecity/{date}/{city}")
    public List<User> getUsersByDateAndCity(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable String city){
        return uService.getUserByDateAndCity(date, city);
    }
    
}
