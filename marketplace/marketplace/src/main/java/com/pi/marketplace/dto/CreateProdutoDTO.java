package com.pi.marketplace.dto; 
  
 import com.fasterxml.jackson.annotation.JsonFormat; 
 import jakarta.persistence.Column; 
 import jakarta.validation.constraints.Email; 
 import jakarta.validation.constraints.NotBlank; 
 import jakarta.validation.constraints.NotNull; 
 import lombok.AllArgsConstructor; 
 import lombok.Builder; 
 import lombok.Data; 
 import lombok.NoArgsConstructor; 

  
 @Data 
 @Builder 
 @AllArgsConstructor 
 @NoArgsConstructor 
 public class CreateProdutoDTO { 
  
     
     @NotBlank(message = "Nome do Produto é um campo obrigatório!") 
     private String nome; 
  
     @NotBlank(message = "Descrição do produto é um campo obrigatório!") 
     private String desricao; 
     
     
 }