package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @Email(message = "O email deve ser válido.")
    @NotBlank(message = "O email não pode estar vazio.")
    private String email;

    @NotBlank(message = "O telefone não pode estar vazio.")
    @Pattern(regexp = "\\d{8,}", message = "O telefone deve conter apenas números e ter no mínimo 8 dígitos.")
    private String telefone;


    public Cliente() {
        // Construtor padrão necessário para JPA fica vazio mesmo
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
