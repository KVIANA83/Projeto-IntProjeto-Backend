package com.pi.marketplace.entities;

import java.util.Scanner;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

//Classe Categoria da Entidade Categoria do MySQL
@Entity
@Data
public class Categoria{
		Scanner sc = new Scanner(System.in);
		
		//Atributos da Entidade Categoria do MySQL
		private int idCategoria;
		public String nomeCategoria;
		public String descricaoCategoria;
	
	
	//ID Categoria 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCategoria(){
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria){
		this.idCategoria = idCategoria;
	}
	
	//Nome do Categoria 
	public String getNomeCategoria(){
		return nomeCategoria;
	}
	
	public void setNomeCategoria(String nomeCategoria){
		this.nomeCategoria = nomeCategoria;
	}
	
	//Descrição do Categoria 
	public String getDescricaoCategoria(){
		return descricaoCategoria;
	}
	
	public void setDescricaoCategoria(String descricaoCategoria){
		this.descricaoCategoria = descricaoCategoria;
	}
	
}