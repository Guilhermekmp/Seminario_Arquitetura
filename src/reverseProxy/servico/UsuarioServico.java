package reverseProxy.servico;

import reverseProxy.entidade.Usuario;

import java.util.ArrayList;
import java.util.List;

public final class UsuarioServico extends AbstractServico<Usuario> {

    public static final String USUARIO_NÃO_ECONTRADO = "Usuario não econtrado";
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    private UsuarioServico instancia;

    public UsuarioServico getInstance(){
        if(instancia == null){
            instancia = new UsuarioServico();
        }
        return instancia;
    }


    public UsuarioServico() {
        this.nome = "Serviço Usuario";
    }

    @Override
    public Integer incrementaSequence() {
        sequence += sequence;
        return sequence;
    }



    @Override
    public Boolean set(Usuario usuario) {
        usuarios.forEach(u ->{
            if(u.getNome() == usuario.getNome()){
                throw new RuntimeException();
            }
        } );
        usuarios.add(usuario);
        return true;
    }


    @Override
    public List<Usuario> get() {
        return usuarios;
    }

    @Override
    public Usuario getById(Integer id) {
        try {
            return usuarios.get(id);
        }
        catch (Exception e){
            System.out.println(USUARIO_NÃO_ECONTRADO);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        try {
            usuarios.remove(id);
        }
        catch (Exception e){
            System.out.println(USUARIO_NÃO_ECONTRADO);
        }
    }

    @Override
    public Usuario put(Usuario usuario) {
        try {
            usuarios.forEach(u ->{
                if(u.getId() == usuario.getId()){
                    u = usuario;
                }
            } );
        }
        catch (Exception e){
            System.out.println(USUARIO_NÃO_ECONTRADO);
        }
       return usuario;
    }
}
