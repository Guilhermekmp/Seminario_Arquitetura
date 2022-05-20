package reverseProxy.entidade;

import java.util.HashMap;
import java.util.Map;

public class Usuario {

    public void setProduto(Map<Produto, Integer> produto) {
        this.produto = produto;
    }

    private Integer id;

    private String nome;

    private Double saldo;

    private String senha;

    private Map<Produto,Integer> produto = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Map<Produto, Integer> getProduto() {
        return produto;
    }

    public Usuario(String nome, Double saldo, String senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.senha = senha;
    }

}
