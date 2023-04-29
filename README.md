# Projeto Integrador backend Java

- Java 20
- Springboot 3.0.6

### Requisitos

Instalar o Docker: 
- Ubuntu https://docs.docker.com/engine/install/ubuntu/ 
- Mac https://docs.docker.com/desktop/install/mac-install/ 
- Windows https://docs.docker.com/desktop/install/windows-install/

## Como rodar o projeto

Caso esteja utilizando uma máquina Linux ou Mac, basta abrir um terminal da raiz do projeto (na mesma pasta que esse aquivo) e digitar o comando `make docker/up`, quando quiser derrubar o projeto é só utilizar o comando `make docker/down`

Caso esteja utilizando uma máquina Windows é só rodar os comandos `docker compose up --build -d` e para derrubar o projeto o comando `docker compose down`

Cuidado que o Docker pode consumir um bom espaço em disco caso fique subindo e descendo muitas vezes o projeto. Dessa forma, para liberar espaço é só rodar o comando `docker system prune` e quando aparecer a opção para escolhar entrar com o valor `Y`


## Estrutura do projeto

```shell

.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── senac
│   │   │           └── projetoIntegrador
│   │   │               ├── config
│   │   │               │   └── dao
│   │   │               ├── health
│   │   │               │   ├── controller
│   │   │               │   └── response
│   │   │               └── senaccoin
│   │   │                   ├── controller
│   │   │                   ├── dto
│   │   │                   │   └── enums
│   │   │                   ├── repository
│   │   │                   │   └── impl
│   │   │                   ├── request
│   │   │                   ├── response
│   │   │                   └── service
│   │   │                       └── impl
│   │   └── resources
│   │       └── mysql.init
│   └── test
│       └── java
│           ├── br
│           │   └── com
│           │       └── empresa
│           │           └── api
│           └── com
│               └── senac
│                   └── projetoIntegrador

```

- O código em si do projeto se inicia dentro da pasta `projetoIntegrador`
- Dentro da pasta `config/dao` está o objeto que se conecta com o banco de dados
- Pode-se observar que existe uma pasta para cada contexto, no exemplo acima uma para o health, que é somente um contexto para sabermos se o serviço está em pé ou não, e o contexto senaccoin. É fortemente sugerido que dentro de cada contexto possua pelo menos uma pasta controller, uma repository, uma service, uma request e, por fim, uma response.
- A pasta reposotiry contém o código necessário para acessar o banco de dados
- A pasta service contém código relacionado a regras de negócio e chama o repository para buscar, inserir ou atualizar os dados no banco de dados
- A pasta controller é responsável por conter o código necessário para conseguirmos mapear os endponis (url) no navegador para executar um determinado código. É recomendado que a responta a ser enviada para o usuário `ResponseEntity` seja criada nessa camada
- A pasta dto contém a representação em Java das entidades presentes no banco de dados necessárias para o contexto funcionar
- A pasta request contém código que são mapeados para objetos JSON que o controller espera receber
- A pasta response faz o mesmo que a request, porém, na resposta da aplicação para o usuário
- Vale observar que dentro das pastas repository e service existe uma pasta chamada `impl`, essa é uma abreviação para `implementation`. Ou seja, dentro da pasta repository e service existem interfaces e a implementação dessas interfaces fica dentro das respectivas pastas impl
- A pasta resouces contém arquivos de configuração, no caso o `application.properties`. Dentro dessa pasta existe uma pasta chamada `mysql.init`, dentro dela existe código SQL para inicialização do banco de dados assim que o *docker* rodar. Isto é, antes da API backend subir, o banco de dados é criado de forma que a API saiba trabalhar
- A pasta test não é muito alvo de nossos estudos, porém, nela contém os testes automatizados para, assim que o projeto for buildado, rodar e verificar se alguma alteração no código alterou ou não o comportamento da aplicação