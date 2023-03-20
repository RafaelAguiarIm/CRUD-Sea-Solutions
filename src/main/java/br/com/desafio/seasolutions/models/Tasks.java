package br.com.desafio.seasolutions.models;

import br.com.desafio.seasolutions.dtos.TasksDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Tasks implements Serializable {
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime initialDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate finalyDate;

    private Boolean status = false;

    public void status() {
        this.status = true;
    }

    public Tasks() {
    }

    public Tasks(Long id, String name, String description, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Tasks(TasksDTO tasksDTO) {
        this.id = tasksDTO.getId();
        this.name = tasksDTO.getName();
        this.description = tasksDTO.getDescription();
        this.initialDate = tasksDTO.getInitialDate();
        this.finalyDate = tasksDTO.getFinalyDate();
        this.status = tasksDTO.getStatus();
    }
}
