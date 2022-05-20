package reverseProxy.servico;

import reverseProxy.entidade.Produto;
import reverseProxy.entidade.Usuario;

public final class ReverseProxy {

    private static ReverseProxy instancia;

    private ProdutoServico produtoServico = new ProdutoServico();

    private UsuarioServico usuarioServico = new UsuarioServico();

    public static ReverseProxy getInstance(){
        if(instancia == null){
            instancia = new ReverseProxy();
        }
        return instancia;
    }

    public void cadastrarUsuario(Integer id ,String nome, Double saldo, String senha){
        try {
            usuarioServico.set(new Usuario(id,nome,saldo,senha));
            System.out.println("Cadastro de " + nome + " Realizado");
        }
        catch (Exception e){
            System.out.println("Erro ao cadastrar usuario!");
        }
    }

    public void validarUsuario(String nome, String senha){
        System.out.println("Login com usuario: " + nome + " e senha: " + senha);
        usuarioServico.get().forEach( usuario -> {
            if (usuario.getNome() == nome && usuario.getSenha() == senha){
                System.out.println("Usuario autorizado!");
                return;
            }
            else{
                System.out.println("Credenciais incorretas!");
            }
        });
    }

    public void deletarUsuario(Integer id){
        System.out.println("Deletando usuario de id: " + id);
        try {
            usuarioServico.delete(id);
            System.out.println("Usuario deletado");
        }
        catch (Exception e){
            System.out.println("Erro a deletar usuario");
        }
    }

    public void cadastrarProduto(Integer id, String nome, Double valor){
        try {
            produtoServico.set(new Produto(id,nome,valor));
            System.out.println("Produto cadastrado");
        }
        catch (Exception e){
            System.out.println("Erro ao cadastrar produto!");
        }
    }

    public void comprarProduto(Integer idUsuario, Integer idProduto, Integer qtd){
        Usuario usuario = usuarioServico.getById(idUsuario);

        Produto produto = produtoServico.getById(idProduto);

        if(!validarCompra(usuario.getSaldo(), calcularPreco(produto,qtd))){
            System.out.println("Não possui saldo suficiente");
            return;
        }
        System.out.println("Saldo anterior: " + usuario.getSaldo());
        usuario.setSaldo(usuario.getSaldo() - calcularPreco(produto,qtd));
        System.out.println("Saldo atual: " + usuario.getSaldo());
    }

    private Double calcularPreco(Produto produto, Integer qtd){
        return produto.getValor() * qtd;
    }

    private Boolean validarCompra(Double saldo, Double valor){
        return 0 < (saldo - valor);
    }
}
