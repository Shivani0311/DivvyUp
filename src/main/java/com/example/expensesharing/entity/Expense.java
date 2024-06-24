package com.example.expensesharing.entity;
import java.math.BigDecimal;


import javax.persistence.*;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;
	
	 @ManyToOne
	 @JoinColumn(name = "group_id")
	 private Group group;
	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getDescription() {
		 return description;
	 }

	 public void setDescription(String description) {
		 this.description = description;
	 }

	 public BigDecimal getAmount() {
		 return amount;
	 }

	 public void setAmount(BigDecimal amount) {
		 this.amount = amount;
	 }
	
	 // Getters and Setters
	
}
