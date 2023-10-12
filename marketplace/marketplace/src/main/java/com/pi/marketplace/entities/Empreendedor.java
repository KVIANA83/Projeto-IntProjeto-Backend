package com.pi.marketplace.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//Classe Empreendedor da Entidade Empreendedor do MySQL
@Entity
@Data
public class Empreendedor{
        
        //Atributos da Entidade Empreendedor do MySQL
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idEmpreendedor;
        private int dataNascimento;
        private String telefone;
        private String nomeCompleto;
        private String razaoSocial;
        private String endereco;
        private String email;
        private String senha;
    
	
    //ID Empreendedor 
    public int getIdEmpreendedor(){
        return idEmpreendedor;
    }
	
    public void setIdEmpreendedor(int idEmpreendedor){
        this.idEmpreendedor = idEmpreendedor;
    }
        
        //Data de Nascimento do Empreendedor
    public int getDataNascimento(){
        return dataNascimento;
    }    
        
    public void setDataNascimento(int dataNascimento){
        this.dataNascimento= dataNascimento;
    }
	
    //Telefone do Empreendedor 
    public String getTelefone(){
        return telefone;
    }
	
    public void setIdUsuario(String telefone){
        this.telefone = telefone;
    }
	
    //Nome Completo de Empreendedor 
    public String getNomeCompleto(){
        return nomeCompleto;
    }
	
    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }
	
    //Razão  Social 
    public String getRazaoSocial(){
        return razaoSocial;
    }
	
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
	
    //Endereço 
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
	
    //E-mail do Empreendedor 
    public String getEmail(){
        return email;
    }
	
    public void setEmail(String email){
        this.email = email;
    }
	
    //Senha de Empreendedor
    public String getSenha(){
        return senha;
    }
	
    public void setSenha(String senha){
        this.senha = senha;
    }
	
}