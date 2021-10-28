# Aplicação Spring Boot Para cadastro de Grafos


# Resumo
+ Aplicação criada para cadstro de Grafos, onde os vértices do grafo representa um bairro e suas arestas as rotas entre o bairro.


#Depêndencias do projeto
Foi utilizado o [Spring Initializr](https://start.spring.io/) para criar o projeto de forma mais simples
e selecionadar as dependências abaixo.
1. **spring-boot-starter-data-jpa.**
2. **spring-boot-starter-web.**
3. **Maven** para build de projeto.
4. **springfox-swagger-ui.**
5. **h2** base de dados.

#Inicialização da aplicação
+ Para inicializar a aplicação basta inserir o comando **mvn spring-boot:run** no terminal.

#Documentação
+ Foi criada também uma documentação em Swagger que pode ser acessada no endereço: (http://localhost:8080/swagger-ui.html#/)

# Rotas da aplicação
Existem duas rotas finalizadas da aplicação e uma ainda em desenvolvimento:
 - Para Cadastrar um grafo essa rota é responsável por receber um grafo no formato JSON e fazer o devido salvamento do mesmo.
  Exemplo: localhost:8080/grafo que faz uso do verbo HTTP POST.
 - Para recuperar os grafos salvos por ID. Exemplo localhost:8080/grafo/1 esta fazendo uso do verbo HTTP GET.
 - Existe outra rota, porém essa ainda não foi finalizada, mas que existem testes é a rota quando informado um ponto A e um ponto B
 a aplicação deve devolver todas as possíveis rotas entre esses pontos. Exempo localhost:8080/rotas/de/{pontoA}/para/{pontoB} 

# Rodando a Aplicação
  - A aplicação pode ser rodada com o comando *mvn spring-boot:run*  