
# API Rest - CRUD Sea Solutions
Este projeto consiste na implementação completa do sistema de gerenciamento do Instituto Metamorfose. Sendo ele implementado uma parte no repositório público, e o restante dos módulos estaram no repositório privado.


![Badge Concluído](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)

> 🚧  Projeto submetido para avaliação 🚧

## Descrição

O projeto consiste em CRUD implementado como desafio para teste de seleção.
Nesse projeto foi desenvolvido uma API utilziando Spring boot, nessa api, é encontrado um CRUD de Tasks, contendo os métodos básicos Create, Read, Update e Delete.
Além desses métodos, foi implementado tambem, os métodos para finalizar uma Task, método apra buscar as tasks finalizadas e outro para buscar as tasks pendentes.

>### Módulos do sistema.

### :hammer: Funcionalidades desenvolvidos

- `CRUD Tasks`: Controle total das tasks
- `Validações`: Validações das tasks inseridas, se já existem no banco de dados, se a task finalizada está OK dentre outras validações
- `Finalização da Task`: Ao finalizar a task, o status muda para True, e o atributo finalDate captura a data e hora que a task foi finalizada
- `Exceções`: ResourceExceptionHandler para ter um maior controle das exceções, StandartError apra deixar o stack mais visualmente mais agradável entre outras
- `Perfis de desenvolvimento`: Sendo o perfil de Test (Usado com H2) e o perfil Dev (Usado com MySql), ambos configurados no aplicatiom.properties

<hr>

### Os Endpoints criados foram: (Rotas locais)
-   `Método POST save():` localhost:8080/tasks
-   `Método GET listAll():` localhost:8080/tasks/listAll
-   `Método GET listAllTrue():` localhost:8080/tasks/true
-   `Método GET listAllFalse():` localhost:8080/tasks
-   `Método GET findById():` localhost:8080/tasks/{id}
-   `Método DELETE delete():` localhost:8080/tasks/delete/{id}
-   `Método PUT udpate():` localhost:8080/tasks/5
-   `Método PUT finalize():` localhost:8080/tasks/finalize/{id}


### Exemplo de uma chamada POST para o método save() ou PUT para o método finalize()
```json
{
	"name": "Tarefa 01",
	"description": "Descrição da Tarefa"
}
```


### Tecnologias utilizadas

- Spring Framework
- Java 17
- JPA/Hibernate
- Lombok
- Apache Tomcat 9
- API Rest
- H2 Databases
- MySql

## Ferramentas Usadas Para Implementação
* ### IntelliJ IDEA

## Padrão de Projeto Aplicado
* MVC(MODEL,VIEW,CONTROLLER) em um sistema desktop java;
    * O princípio básico do MVC é a divisão da aplicação em três camadas: a camada de interação do usuário (view), a camada de manipulação dos dados (model) e a camada de            controle (controller);
    * MODEL
        1. A responsabilidade dos models é representar o negócio. Também é responsável pelo acesso e manipulação dos dados na sua aplicação.
    * CONTROLER
        1. É a camada de controle, responsável por ligar o model e a view, fazendo com que os models possam ser repassados para as views e vice-versa.
    * VIEW
        1. A view é responsável pela interface que será apresentada, mostrando as informações do model para o usuário.

## Padrão DTO
* Padrão para controle dos dados da Entidade

# Para executar o projeto, siga os seguintes passos:

1. Clone o repositório em sua máquina
2. Abra o projeto em sua IDE de preferência
3. Configure o banco de dados MySQL em sua máquina e atualize as configurações do arquivo `application.properties` com as informações de conexão do seu banco de dados
4. Acesse a aplicação em seu navegador através do endereço `http://localhost:8080` e informe os endpoints de acordo com o comentado na classe Controller

