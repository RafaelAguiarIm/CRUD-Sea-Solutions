package br.com.desafio.seasolutions.dtos;

import br.com.desafio.seasolutions.models.Tasks;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TasksDTO implements Serializable {
    private  static final long serialVersionUID = 1L;

    protected Long id;

    @NotBlank (message = "O campo NOME é obrigatório")
    protected String name;
    @NotBlank (message = "O campo DESCRIÇÃO é obrigatório")
    protected String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime initialDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate finalyDate;

    protected Boolean status;



    public TasksDTO() {
    }

    public TasksDTO(Long id, String name, String description, LocalDateTime initialDate, LocalDate finalyDate, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
        this.finalyDate = finalyDate;
        this.status = status;
    }

    public TasksDTO(Tasks tasks) {
        this.id = tasks.getId();
        this.name = tasks.getName();
        this.description = tasks.getDescription();
        this.initialDate = tasks.getInitialDate();
        this.finalyDate = tasks.getFinalyDate();
        this.status = tasks.getStatus();

    }
}
