package br.com.desafio.seasolutions.services;

import br.com.desafio.seasolutions.dtos.TasksDTO;
import br.com.desafio.seasolutions.models.Tasks;
import br.com.desafio.seasolutions.repositories.TasksRepository;
import br.com.desafio.seasolutions.services.exceptions.DataIntegrityViolationException;
import br.com.desafio.seasolutions.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository repository;

    public Tasks save(TasksDTO tasksDTO){
        tasksDTO.setId(null);
        Tasks tasks = new Tasks(tasksDTO);
        validaTask(tasksDTO);
        return repository.save(tasks);
    }

    public Tasks findById(Long id){
        Optional<Tasks> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Task not a found! Id: "+ id));
    }

    public List<Tasks> findAll(){
        return repository.findAll();
    }

    public Tasks update(Long id, TasksDTO tasksDTO) {
        tasksDTO.setId(id);
        var tasks = findById(id);
        validaTask(tasksDTO);
        tasks = new Tasks(tasksDTO);
        return  repository.save(tasks);
    }


    public Tasks finalizeTask(Long id, TasksDTO tasksDTO) {
        tasksDTO.setId(id);
        var tasks = findById(id);
        if (tasks.getStatus() != false){
            throw new DataIntegrityViolationException("The task "+tasks.getId()+ " has already finished!");
        } else if (!tasks.getName().equals(tasksDTO.getName()) || !tasks.getDescription().equals(tasksDTO.getDescription())) {
            throw new DataIntegrityViolationException("Task name "+tasks.getName()+ " cannot be modified!");
        }

        tasks = new Tasks(tasksDTO);
        tasks.setStatus(true);
        tasks.setFinalyDate(LocalDate.now());
        return  repository.save(tasks);
    }
    public Tasks getReferenceById(Long id) {
        var tasks = findById(id);
        tasks.setStatus(true);
        return repository.save(tasks);
    }

    public void deleteById(Long id) {
        var tasks = findById(id);
        repository.delete(tasks);
    }

    public Page<TasksDTO> listByStatusTrue(Pageable pageable){
        var page =  repository.findAllByStatusTrue(pageable).map(TasksDTO::new);
        return page;
    }

    public Page<TasksDTO> listByStatusFalse(Pageable pageable){
        var page =  repository.findAllByStatusFalse(pageable).map(TasksDTO::new);
        //Cod 200 ok
        return page;
    }

    //valida Tasks
    private void validaTask(TasksDTO tasksDTO) {
        Optional<Tasks> tasks = repository.findByName(tasksDTO.getName());
        if (tasks.isPresent() && tasks.get().getId() != tasksDTO.getId()){
            throw new DataIntegrityViolationException("Tarefa já cadastrada");
        }
    }




}
