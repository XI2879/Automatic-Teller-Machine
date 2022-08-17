package com.example.API.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
//@Data
@Entity
@Table(name="players")
@IdClass(CompositeId.class)
public class Player {
	@Column
	private int id;
	@Column
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int savingNo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int debitNo;
	@Column
	private int balance;
	
	public Player() {
		
	}

	public Player(int id, String name, int savingNo, int debitNo, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.savingNo = savingNo;
		this.debitNo = debitNo;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSavingNo() {
		return savingNo;
	}

	public void setSavingNo(int savingNo) {
		this.savingNo = savingNo;
	}

	public int getDebitNo() {
		return debitNo;
	}

	public void setDebitNo(int debitNo) {
		this.debitNo = debitNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
	

}
