
# Sistema de Gestão Clínica - Instituto Metamorfose
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
- `Perfis de desenvolvimento`: Sendo o perfil de Test e o perfil Dev, ambos configurados no aplicatiom.properties

<hr>


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

## Contribuição
Este projeto foi desenvolvido por Rafael Aguiar. Se você deseja contribuir para o projeto, sinta-se à vontade para fazer um fork do repositório e submeter um pull request com suas alterações. Será um prazer receber contribuições da comunidade!