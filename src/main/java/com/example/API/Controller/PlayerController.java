package com.example.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.API.Entity.Player;
import com.example.API.Exception.ResourceNotFoundException;
import com.example.API.Service.PlayerService;


@RestController
@RequestMapping("/api")
public class PlayerController {
	

	
	@Autowired
	private PlayerService service;
	
	public PlayerController(PlayerService service) {
	super();
	this.service = service;
}

	//get all records
        //http://localhost:8081/api/players
	@GetMapping("/players")
    public List<Player> getBooks() {
        return service.getBook();
    }
	
	//view balance api
	//unknown url gives resource not found
//	http://localhost:8081/api/view/composite?savingNo=100
	@GetMapping("/view/composite")
	public  int viewBalance(@RequestParam int savingNo) throws ResourceNotFoundException{
	
		return service.view(savingNo);
	
	}
	
	//deposit balance and update in database as well
	//http://localhost:8081/api/deposit/{amount}/composite?savingNo=100
	@PatchMapping("/deposit/{amount}/composite")
	public String depositAmount(@RequestParam int savingNo,@PathVariable int amount) throws ResourceNotFoundException{
		service.deposit(savingNo, amount);
		return "Amount deposit success";
		
	}
	
	//withdraw balance  and update to database as well
	//http://localhost:8081/api/withdraw/{amount}/composite?savingNo=100
	@PatchMapping("/withdraw/{amount}/composite")
	public String withdrawAmount(@RequestParam int savingNo,@PathVariable int amount) throws ResourceNotFoundException {
		service.withdraw(savingNo, amount);
		return "Amount withdrawn success";
	}
	
	//Transfer to another account and update database as well
	//http://localhost:8081/api/transfer/{amount}/composite?savingFrom=100&savingTo
	@PutMapping("/transfer/{amount}/composite")
	public String transferAmount(@RequestParam int savingFrom,@PathVariable int amount,
			@RequestParam int savingTo ) throws ResourceNotFoundException {
		service.transfer(amount, savingFrom, savingTo);
		return "Amount Transfer success";

}
	
	
	
	
	
	
}