package reverseProxy;

import reverseProxy.servico.ReverseProxy;

public class Cliente {
    public static void main(String[] args) {
        ReverseProxy reverseProxy = ReverseProxy.getInstance();

        reverseProxy.cadastrarUsuario(0,"Italo",800.0, "guiDevDePhp");

        reverseProxy.cadastrarUsuario(0,"Italo",800.0, "guiDevDePhp");

        reverseProxy.cadastrarUsuario(1,"Gui", 10.0, "12345");

        reverseProxy.cadastrarProduto(0,"Pão", 200.0);

        reverseProxy.cadastrarProduto(0,"Pão", 200.0);

        reverseProxy.comprarProduto(0,0, 2);


    }
}
