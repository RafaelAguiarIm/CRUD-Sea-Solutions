package br.com.desafio.seasolutions.controllers;

import br.com.desafio.seasolutions.dtos.TasksDTO;
import br.com.desafio.seasolutions.models.Tasks;
import br.com.desafio.seasolutions.services.TasksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/tasks")
public class TasksController {

    @Autowired
    TasksService service;

    //localhost:8080/tasks - save
    @PostMapping
    public ResponseEntity create(@RequestBody @Valid TasksDTO tasksDTO, UriComponentsBuilder uriBuilder) {
        var tasks = new Tasks(tasksDTO);
        service.save(tasksDTO);
        //Cod 201 Created
        var uri = uriBuilder.path("/tasks/{id}").buildAndExpand(tasks.getId()).toUri();
        return ResponseEntity.created(uri).body(new TasksDTO(tasks));
    }

    //localhost:8080/tasks/finalize/id
    @PutMapping(value = "/finalize/{id}")
    @Transactional
    public ResponseEntity finalizeTask(@PathVariable Long id, @RequestBody @Valid TasksDTO tasksDTO){
        var tasks = service.finalizeTask(id, tasksDTO);
        return ResponseEntity.ok().body(tasks);
    }

    //localhost:8080/tasks/id
    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid TasksDTO tasksDTO){
        var tasks = new Tasks(tasksDTO);
        service.update(id, tasksDTO);
        return ResponseEntity.ok().body(new TasksDTO(tasks));
    }

    //localhost:8080/tasks/listAll
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<TasksDTO>> findAll(){
        List<Tasks> listAllTasks = service.findAll();
        List<TasksDTO> lisAllTasksDTO = listAllTasks.stream().map(tasks -> new TasksDTO(tasks)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lisAllTasksDTO);
    }

    //localhost:8080/tasks/true
    @GetMapping("/true") //Anotation Get
    public ResponseEntity<Page<TasksDTO>> listByStatusTrue(@PageableDefault(size=10, sort = {"name"}) Pageable pageable){
        Page<TasksDTO> listAllTasksTrue =  service.listByStatusTrue(pageable);
        return ResponseEntity.ok().body(listAllTasksTrue);
    }

    //localhost:8080/tasks/false
    @GetMapping("/false") //Anotation Get
    public ResponseEntity<Page<TasksDTO>> listByStatusFalse(@PageableDefault(size=10, sort = {"name"}) Pageable pageable){
        Page<TasksDTO> listAllTasksFalse = service.listByStatusFalse(pageable);
        return ResponseEntity.ok().body(listAllTasksFalse);
    }

    //localhost:8080/tasks/id
    @GetMapping(value = "/{id}")
    public ResponseEntity<TasksDTO> findById(@PathVariable Long id){
        Tasks tasks = service.findById(id);
        return ResponseEntity.ok().body(new TasksDTO(tasks));
    }

    //localhost:8080/tasks/delete/id
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }


}
