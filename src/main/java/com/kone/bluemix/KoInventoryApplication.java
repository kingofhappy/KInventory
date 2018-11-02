package com.kone.bluemix;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
/**
 * @author sradhakrishnan2
 * Configuration for Spring Boot App and RestTemplate alongwith HttpComponentsClientHttpRequestFactory
 *
 */
@Configuration
@SpringBootApplication
public class KoInventoryApplication {


	 @Bean
	  public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
	    PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
	    result.setMaxTotal(20);
	    return result;
	  }

	  @Bean
	  public RequestConfig requestConfig() {
	    RequestConfig result = RequestConfig.custom()
	      .setConnectionRequestTimeout(1200000)
	      .setConnectTimeout(26000)
	      .setSocketTimeout(6000)
	      .build();
	    return result;
	  }

	  @Bean
	  public CloseableHttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager, RequestConfig requestConfig) {
	    CloseableHttpClient result = HttpClientBuilder
	      .create()
	      .setConnectionManager(poolingHttpClientConnectionManager)
	      .setDefaultRequestConfig(requestConfig)
	      .build();
	    return result;
	  }

	  @Bean("simpleRestTemplate")
	  public RestTemplate restTemplate(HttpClient httpClient) {
	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    requestFactory.setHttpClient(httpClient);
	    return new RestTemplate(requestFactory);
	  }
	  
	public static void main(String[] args) {
		SpringApplication.run(KoInventoryApplication.class, args);
	}
}
