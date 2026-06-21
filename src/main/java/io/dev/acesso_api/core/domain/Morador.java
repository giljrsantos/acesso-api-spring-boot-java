package io.dev.acesso_api.core.domain;

public class Morador {
    private Long id;
    private String cpf;
    private String endereco;
    private String celular;
    private Pessoa pessoa;

    public Morador() {
    }

    public Morador(Long id, String cpf, String endereco, String celular, Pessoa pessoa) {
        this.id = id;
        this.cpf = cpf;
        this.endereco = endereco;
        this.celular = celular;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


}