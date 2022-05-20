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

    private void cadastrarUsuario(String nome, Double saldo, String senha){
        try {
            usuarioServico.set(new Usuario(nome,saldo,senha));
        }
        catch (Exception e){
            System.out.println("Erro ao cadastrar usuario!");
        }
    }

    private void validarUsuario(String nome, String senha){
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

    private void deletarUsuario(Integer id){
        System.out.println("Deletando usuario de id: " + id);
        try {
            usuarioServico.delete(id);
            System.out.println("Usuario deletado");
        }
        catch (Exception e){
            System.out.println("Erro a deletar usuario");
        }

    }
}
