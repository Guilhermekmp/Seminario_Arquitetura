package reverseProxy.servico;

import reverseProxy.entidade.Usuario;

public abstract class AbstractServico<T> implements ServicoInterface<T>{

    public String nome;

    public Integer sequence = 0;
}
