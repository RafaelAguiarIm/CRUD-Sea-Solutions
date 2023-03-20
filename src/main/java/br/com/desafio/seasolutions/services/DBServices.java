package br.com.desafio.seasolutions.services;

import br.com.desafio.seasolutions.models.Tasks;
import br.com.desafio.seasolutions.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class DBServices {

    public DBServices(){
    }

    @Autowired
    private TasksRepository repository;

    public void instanciaDB(){

        Tasks tasks1 = new Tasks(null, "Tarefa 01" , "Descrição da tarefa 01", false);
        Tasks tasks2 = new Tasks(null, "Tarefa 02" , "Descrição da tarefa 02", false);
        Tasks tasks3 = new Tasks(null, "Tarefa 03" , "Descrição da tarefa 03", false);
        Tasks tasks4 = new Tasks(null, "Tarefa 04" , "Descrição da tarefa 04", false);
        Tasks tasks5 = new Tasks(null, "Tarefa 05" , "Descrição da tarefa 04", true);

        repository.saveAll(Arrays.asList(tasks1, tasks2, tasks3, tasks4, tasks5));

    }
}
