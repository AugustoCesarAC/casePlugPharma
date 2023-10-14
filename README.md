<h1>Projeto de Cadastro de Pessoa Física com Consumo de CEP</h1>
<p>
  Este é um projeto Spring Boot que permite o cadastro de pessoas físicas e
  consome informações de CEP de uma API externa para preencher os detalhes de
  endereço automaticamente.
</p>

<h2>Funcionalidades</h2>
<ul>
  <li>Cadastro de Pessoa Física</li>
  <li>Consulta de Pessoa Física</li>
  <li>Exclusão de Pessoa Física</li>
  <li>Consumo de informações de CEP de uma API externa ViaCep</li>
  <li>Persistência de dados em um banco de dados</li>
  <li>Tratativa de erros</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Spring Web</li>
  <li>Hibernate</li>
  <li>Swagger para documentação da API</li>
  <li>RestTemplate para integração com serviços externos</li>
  <li>Banco de Dados Relacional (por exemplo, MySQL, PostgreSQL, etc.)</li>
  <li>API de Consulta de CEP ViaCep</li>
</ul>

<h2>Pré-requisitos</h2>
<ul>
  <li>Java 17 ou superior</li>
  <li>Maven</li>
  <li>Banco de Dados configurado e acessível</li>
</ul>

<h2>Configuração</h2>
<ol>
  <li>Clone o repositório para o seu ambiente de desenvolvimento:</li>
</ol>
<code>git clone https://github.com/AugustoCesarAC/casePlugPharma.git</code>

<ol start="2">
  <li>
    Configure o arquivo <code>application.properties</code> com as informações do banco de dados:
  </li>
</ol>
<pre>
        spring.datasource.url=jdbc:mysql://localhost/nome_do_banco?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.database=mysql
        spring.datasource.username=seu_usuario
        spring.datasource.password=sua_senha
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
        spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
        spring.jackson.time-zone=Brazil/East
        springdoc.packagesToScan=com.demonstration.cadastroPessoaJuridica.controller
        springdoc.swagger-ui.use-root-path=true
    </pre
>

<ol start="4">
  <li>Execute o aplicativo Spring Boot:</li>
</ol>
<code>mvn spring-boot:run</code>

<p>
  O aplicativo estará disponível em
  <a href="http://localhost:8080">http://localhost:8080</a>.
</p>

<h2>Uso</h2>
<p>
  Você pode acessar a API através do seu navegador ou usar ferramentas como o
  Postman para testar as funcionalidades disponíveis, como cadastro, consulta,
  atualização e exclusão de pessoas físicas. Certifique-se de que o serviço de
  consulta de CEP também está funcionando corretamente para preencher
  automaticamente os dados de endereço.
</p>

<h2>Exemplos de Endpoints</h2>
<h3>Cadastro de Pessoa Física</h3>
<ul>
  <li><strong>Método</strong>: POST</li>
  <li><strong>Endpoint</strong>: /pessoafisica/new</li>
  <li><strong>Corpo da Requisição</strong>:</li>
</ul>
<pre>
        {
          "nome": "Nome da Pessoa",
          "cpf": "123.456.789-00",
          "cep": "12345678"
        }
    </pre
>

<h3>Consulta de Todos Cadastros de Pessoa Física</h3>
<ul>
  <li><strong>Método</strong>: GET</li>
  <li><strong>Endpoint</strong>: /pessoafisica/list</li>
</ul>

<h3>Exclusão de Pessoa Física</h3>
<ul>
  <li><strong>Método</strong>: DELETE</li>
  <li><strong>Endpoint</strong>: /pessoafisica/delete/{id}</li>
</ul>

<p>
  Certifique-se de ajustar os exemplos acima de acordo com o seu modelo de dados
  e implementação específica.
</p>

<h2>Material de Apoio</h2>
<p>The Guide to RestTemplate <a>https://www.baeldung.com/rest-template</a> </p>
<p>ChatGPT <a>https://chat.openai.com/</a> </p>

<h2>Autores</h2>
<ul>
  <li><a href="https://github.com/AugustoCesarAC">Augusto César</a></li>  
</ul>


