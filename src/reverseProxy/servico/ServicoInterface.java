package reverseProxy.servico;

import reverseProxy.entidade.EntidadeInterface;

import java.util.List;
import java.util.Optional;

public interface ServicoInterface<T> {

    public Integer incrementaSequence();

    public Boolean set(T entidade);

    public List<T> get();

    public T getById(Integer id);

    public void delete(Integer id);

    public T put ( T entidade);
}
