<h2> Este código foi baseado no Post do seguinte Blog</h2>

- [Como usar Elasticsearch com Spring Data](https://reflectoring.io/spring-boot-elasticsearch/)

<h4>Tecnologias usadas</h4>
- Java 11
- Springboot 2.7.10
- Elasticsearch 7.17.9

Este código tem como objetivo demonstrar o uso dos recursos de indexação e pesquisa do Spring Data Elasticsearch em um 
aplicativo de pesquisa simples usado para pesquisar produtos em um inventário de produtos.  
As principais etapas para executar o aplicativo são:

1. Inicie uma instância do Elasticsearch executando o comando Docker run:

> docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.17.9
2. Clone o aplicação e altere o diretório atual para a raiz da mesma.
3. Compile o aplicativo com o Maven

> mvn clean package
4. Inicie a aplição

> java -jar target/<application>.jar
5. O productindex será criado durante a inicialização do aplicação.
6. Acesse o aplicação com a URL: URL http://localhost:8080/search
7. Comece a inserir alguns caracteres na caixa de pesquisa (exemplos: brinquedo, camisa branca, jaqueta, etc), que abrirá uma caixa de preenchimento automático com no máximo 5 sugestões.
8. Complete o texto da pesquisa e clique no botão de pesquisa para ver os resultados da pesquisa.