package com.example.demo.config;
import com.example.demo.Product.Product;
import com.example.demo.ProductCatogery.ProductCatogery;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import  org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration

public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] UnsupportedActions = {HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT};

        // disable for Product Entity
        config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)));

        // disable for ProductCategory Entity
        config.getExposureConfiguration().forDomainType(ProductCatogery.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)));

    }
}

