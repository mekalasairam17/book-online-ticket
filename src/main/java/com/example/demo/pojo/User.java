	package com.example.demo.pojo;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	
	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer userId;
		String userName ;
		String password;
		String confirmPassword;
		String email;
		String mobileNo;
		
	}
