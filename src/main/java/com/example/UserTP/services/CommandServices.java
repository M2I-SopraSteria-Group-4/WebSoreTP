package com.example.UserTP.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTP.entity.*;
import com.example.UserTP.repository.*;

@Service
public class CommandServices {

    @Autowired
    CommandRepository cRepo;

    @Autowired
    CommandLineRepository clRepo;

    @Autowired
	UserRepository uRepo;

    @Autowired
	ArticleRepository aRepo;

    public List<Command> getAllCommands(){
        return cRepo.findAll();
    }

    public List<Command> getByUser(int user_id){
        User u = uRepo.findById(user_id).orElse(null);
        return u.getCommand();
    }

    public Command getOneCommand(int id){
        return cRepo.findById(id).orElse(null);
    }

    public void createCommand(Command c){
        cRepo.save(c);
    }

    public void deleteCommand(int id){
        Command c = cRepo.findById(id).orElse(null);
        if(c!=null) cRepo.delete(c);
    }

    public void updateCommand(Command c, int id){
        Command command = cRepo.findById(id).orElse(null);
        if(command!=null){
            command.setCommandDate(c.getCommandDate());
            command.setUser(c.getUser());
            command.setCommandLine(c.getCommandLine());
            command.setPayment(c.getPayment());
            cRepo.save(command);
        }
    }

    public List<CommandLine> getAllCL(){
        return clRepo.findAll();
    }

    public CommandLine getOneCL(int id){

        return clRepo.findById(id).orElse(null);
    }

    public void createCL(CommandLine cl){
        clRepo.save(cl);
    }

    public void deleteCL(int id){
        CommandLine cl = clRepo.findById(id).orElse(null);
        if(cl!=null) clRepo.delete(cl);
    }

    public void updateCL(CommandLine cl, int id){
        CommandLine cLine = clRepo.findById(id).orElse(null);
        if(cLine != null) {
            cLine.setCommand(cl.getCommand());
            cLine.setArticle(cl.getArticle());
            cLine.setQuantity(cl.getQuantity());

            clRepo.save(cLine);
        }
    }

    public List<Article> getAllArticles(){
        return aRepo.findAll();
    }

    public Article getOneArticle(int id){

        return aRepo.findById(id).orElse(null);
    }

    public void createArticle(Article a){
        aRepo.save(a);
    }

    public void deleteArticle(int id){
        Article a = aRepo.findById(id).orElse(null);
        if(a!=null) aRepo.delete(a);
    }

    public void updateArticle(Article a, int id){
        Article article= aRepo.findById(id).orElse(null);
        if(article != null) {
            article.setBrand(a.getBrand());
            article.setDescription(a.getBrand());
            article.setPrice(a.getPrice());
            aRepo.save(article);
        }
    }

    public Article getRandomArticle() {
        List<Article> articles = aRepo.findAll();
        if (articles.size() == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(articles.size());
        return articles.get(randomIndex);
    }

    public List<Command> getCommandByUser(int id){
        User user = uRepo.findById(id).orElse(null);
        return user.getCommand();
    }

    public List<Article> getArticleByCommandId(int id){
        Command command = cRepo.findById(id).orElse(null);
        List<Article> articles = new ArrayList<Article>();
        for(CommandLine cl : command.getCommandLine()){
            articles.add(cl.getArticle());
        }
        return articles;
    }

    public List<Command> getCommandByDates(Date date1, Date date2){
        List<Command> commands = cRepo.findAll();
        List<Command> filteredCommands = new ArrayList<>();
        for(Command c : commands){
            if(c.getCommandDate().after(date1) && c.getCommandDate().before(date2)){
                filteredCommands.add(c);
            }
        }
        return filteredCommands;
    }

    public List<Article> getArticleByBrand(String brand){
        List<Article> articles = aRepo.findAll();
        List<Article> filteredArticles = new ArrayList<>();
        for(Article a : articles){
            if(a.getBrand().equalsIgnoreCase(brand)){
                filteredArticles.add(a);
            }
        }
        return filteredArticles;
    }

    public void createArticleList(List <Article> articles){
        for(Article a : articles){
            aRepo.save(a);
        }
    }




    

}