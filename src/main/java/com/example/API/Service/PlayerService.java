package com.example.API.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Entity.Player;
import com.example.API.Repository.PlayerRepository;
@Service
public class PlayerService {
	@Autowired
	private PlayerRepository reposit;
	

	public PlayerService(PlayerRepository reposit) {
		super();
		this.reposit = reposit;
	}
	
	public List<Player> getBook() {
        return reposit.findAll();
    }
	
	public int view(int savingNo) {
		
		Player player=reposit.findById( savingNo).orElseThrow();
		return player.getBalance();
          
	}
	public void deposit(int savingNo,int amount) {
		if(amount>0) {
		
		Player player=reposit.findById( savingNo).orElseThrow();
		player.setBalance(player.getBalance()+amount);
		reposit.save(player);
		}else {
			System. out. println("invalid amount entered");
		}
	}
	public void withdraw(int savingNo,int amount) {
		if(amount>0) {
		Player player=reposit.findById( savingNo).orElseThrow();
		player.setBalance(player.getBalance()-amount);
		reposit.save(player);
	}else {
		System. out. println("invalid amount entered");
	}
	}
	public void transfer(int amount,int savingFrom,int savingTo) {
		if(amount>0) {
		Player player1=reposit.findById( savingFrom).orElseThrow();
		Player player2=reposit.findById( savingTo).orElseThrow();
		player1.setBalance(player1.getBalance()-amount);
		reposit.save(player1);
		player2.setBalance(player2.getBalance()+amount);
		reposit.save(player2);
	}else {
		System. out. println("invalid amount entered");
	}

}
}