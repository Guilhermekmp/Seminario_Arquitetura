package reverseProxy.servico;

import reverseProxy.entidade.Produto;

import java.util.ArrayList;
import java.util.List;

public final class ProdutoServico extends AbstractServico<Produto> {

    public static final String PRODUTO_NÃO_ECONTRADO = "Produto não econtrado";

    private List<Produto> produtos = new ArrayList<Produto>();

    private ProdutoServico instancia;

    private Integer sequence = 0;


    public ProdutoServico getInstance(){
        if(instancia == null){
            instancia = new ProdutoServico();
        }
        return instancia;
    }

    @Override
    public Integer incrementaSequence() {
        sequence += sequence;
        return sequence;
    }

    @Override
    public Boolean set(Produto produto) {
        produtos.forEach(p ->{
            if(p.getNome() == produto.getNome()){
                throw new RuntimeException();
            }
        } );
        produtos.add(produto);
        return true;
    }

    @Override
    public List<Produto> get() {
        return produtos;
    }

    @Override
    public Produto getById(Integer id) {
        try {
            return produtos.get(id);
        }
        catch (Exception e){
            System.out.println(PRODUTO_NÃO_ECONTRADO);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        try {
            produtos.remove(id);
        }
        catch (Exception e){
            System.out.println(PRODUTO_NÃO_ECONTRADO);
        }
    }

    @Override
    public Produto put(Produto produto) {
        try {
            produtos.forEach(p ->{
                if(p.getId() == produto.getId()){
                    p = produto;
                }
            } );
        }
        catch (Exception e){
            System.out.println(PRODUTO_NÃO_ECONTRADO);
        }
        return produto;
    }
}
