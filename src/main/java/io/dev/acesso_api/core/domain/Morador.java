package io.dev.acesso_api.core.domain;

public class Morador {
    private Long id;
    private String rg;
    private String endereco;
    private String celular;
    private Long idPessoa;

    public Morador() {
    }

    public Morador(Long id, String rg, String endereco, String celular, Long idPessoa) {
        this.id = id;
        this.rg = rg;
        this.endereco = endereco;
        this.celular = celular;
        this.idPessoa = idPessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}
