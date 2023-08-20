package com.example.demo.config;
import com.example.demo.Product.Product;
import com.example.demo.ProductCatogery.ProductCatogery;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import  org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration

public class MyDataRestConfig implements RepositoryRestConfigurer {


    private final EntityManager entityManager;


    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] UnsupportedActions = {HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT};

        // disable for Product Entity
        config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)));

        // disable for ProductCategory Entity
        config.getExposureConfiguration().forDomainType(ProductCatogery.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)));


        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entites = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();

        for (EntityType temp:entites){
            entityClasses.add(temp.getJavaType());
        }
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}

