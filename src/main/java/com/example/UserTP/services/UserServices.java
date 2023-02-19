package com.example.UserTP.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTP.entity.Info;
import com.example.UserTP.entity.User;
import com.example.UserTP.entity.Role;
import com.example.UserTP.repository.UserRepository;
import com.example.UserTP.repository.InfoRepository;
import com.example.UserTP.repository.RoleRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository uRepo;

	@Autowired
	InfoRepository iRepo;

	@Autowired
	RoleRepository rRepo;
	
	public List<User> getAllUsers(){
		return uRepo.findAll();
	}
	
	public User getOneUser(int id) {
		return uRepo.findById(id).orElse(null);
	}


	public User getRandomUser() {
        List<User> users = uRepo.findAll();
        if (users.size() == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(users.size());
        return users.get(randomIndex);
    }

	public void deleteUser(int id){
		User u = uRepo.findById(id).orElse(null);
		if (u!=null) uRepo.delete(u);

	}

	public void createUser(User u){
		uRepo.save(u);
	}

	public void updateUser(int id,User u){
		User user = uRepo.findById(id).orElse(null);
		user.setLogin(u.getLogin());
		user.setPassword(u.getPassword());
		user.setConnectionNumber(u.getConnectionNumber());
		user.setCommand(u.getCommand());
		user.setRole(u.getRole());
		user.setInfo(u.getInfo());
		uRepo.save(user);
	}

	public List<Info> getAllInfo(){
		return iRepo.findAll();
	}

	public Info getOneInfo(int id){
		return iRepo.findById(id).orElse(null);
	}

	public Info getUserInfo(int user_id){
		User u = uRepo.findById(user_id).orElse(null);
		return u.getInfo();
	}

	public void deleteInfo(int id){
		Info i = iRepo.findById(id).orElse(null);
		if(i != null) iRepo.delete(i);
	}

	public void createInfo(Info i){
		iRepo.save(i);
	}

	public void updateInfo(int id, Info i){
		Info info = iRepo.findById(id).orElse(null);
		if (i!=null){
			info.setAdress(i.getAdress());
			info.setCity(i.getCity());
			info.setEmail(i.getEmail());
			info.setPhoneNumber(i.getPhoneNumber());
			iRepo.save(info);
		}
	}

	public List<Role> getAllRole(){
		return rRepo.findAll();
	}

	public Role getOneRole(int id){
		return rRepo.findById(id).orElse(null);
	}

	public List<Role> getUserRole(int id){
		User u = uRepo.findById(id).orElse(null);
		return u.getRole();
	}

	public void createRole(Role r){
		rRepo.save(r);
	}

	public void deleteRole(int id){
		Role r = rRepo.findById(id).orElse(null);
		if(r != null) rRepo.delete(r);
	}

	public void updateRole(int id, Role r){
		Role role = rRepo.findById(id).orElse(null);
		if(r != null){
			role.setRoleName(r.getRoleName());
			role.setUser(r.getUser());
			rRepo.save(role);
		}
	}


}
