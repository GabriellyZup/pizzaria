package com.zup.pizzaria.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {

    @NotBlank(message = "Digite seu nome")
    private String nome;
    @NotBlank (message = "Digite seu e-email")
    @Email(message = "Digite um e-mail válido")
    private String email;
    @NotBlank (message = "Digite um telefone")
    @Size(min = 8, message = "Digite um telefone com 8 dígitos ou mais")
    @NotBlank(message = "O telefone não pode estar vazio.")
    @Pattern(regexp = "\\d{8,}", message = "O telefone deve conter apenas números e ter no mínimo 8 dígitos.")

    private String telefone;

    public String getNome(){
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(){
        this.telefone = telefone;
    }
}
