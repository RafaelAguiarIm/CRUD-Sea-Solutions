package br.com.desafio.seasolutions.repositories;

import br.com.desafio.seasolutions.models.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TasksRepository extends JpaRepository<Tasks, Long> {
    Optional<Tasks> findByName(String name);

    Page<Tasks> findAllByStatusTrue(Pageable paginacao);

    Page<Tasks> findAllByStatusFalse(Pageable paginacao);


}
