package com.example.API.Entity;
//for to make two primary keys in one table Composite key used
import java.io.Serializable;
import java.util.Objects;

public class CompositeId implements Serializable{
	
    
	private int savingNo;
	private int debitNo;
	 
	public CompositeId() {
		
	}

	public CompositeId(int savingNo, int debitNo) {
		super();
		this.savingNo = savingNo;
		this.debitNo = debitNo;
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

	@Override
	public int hashCode() {
		return Objects.hash(debitNo, savingNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeId other = (CompositeId) obj;
		return debitNo == other.debitNo && savingNo == other.savingNo;
	}
	

}
