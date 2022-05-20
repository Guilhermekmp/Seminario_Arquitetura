package reverseProxy.entidade;

public class Produto {

    public Produto(Integer id,String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    private Integer id;

    private String nome;

    private Double valor;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
