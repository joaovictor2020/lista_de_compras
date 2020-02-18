package ifal.edu.br.lista_de_compras;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryListaCompras extends CrudRepository<ListaCompras,Long>{
    List<ListaCompras> findByDescricaoContaining(String descricao);
}