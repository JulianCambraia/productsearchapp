package br.com.juliancambraia.productsearchapp.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.time.Duration;

@Configuration
@EnableElasticsearchRepositories(basePackages = "br.com.juliancambraia.productsearchapp.repositories")
@ComponentScan(basePackages = {"br.com.juliancambraia.productsearchapp"})
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration {
    @Override
    @Bean(destroyMethod = "close")
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo("localhost:9200")
                        .withConnectTimeout(Duration.ofSeconds(5))
                        .withSocketTimeout(Duration.ofSeconds(3))
                        .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
