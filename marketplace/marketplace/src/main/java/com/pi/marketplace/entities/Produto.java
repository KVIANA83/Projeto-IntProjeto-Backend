package com.pi.marketplace.entities;

import java.util.Scanner;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

//Classe Produto da Entidade Produto do MySQL
@Entity
@Data
public class Produto{
		Scanner sc = new Scanner(System.in);
		
		//Atributos da Entidade Produto do MySQL
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idProduto;
		public String nomeProduto;
		public String descricaoProduto;
	
	
	//ID Produto 
	public int getIdProduto(){
		return idProduto;
	}
	
	public void setIdProduto(int idProduto){
		this.idProduto = idProduto;
	}
	
	//Nome do Produto 
	public String getNomeProduto(){
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto){
		this.nomeProduto = nomeProduto;
	}
	
	//Descrição do Produto 
	public String getDescricaoProduto(){
		return descricaoProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto){
		this.descricaoProduto = descricaoProduto;
	}
	
}