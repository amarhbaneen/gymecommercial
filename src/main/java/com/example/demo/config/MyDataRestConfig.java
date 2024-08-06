package com.example.demo.config;
import com.example.demo.Contry.Country;
import com.example.demo.Product.Product;
import com.example.demo.ProductCatogery.ProductCatogery;
import com.example.demo.State.State;
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
        DisableMethod(Product.class,config, UnsupportedActions);
        DisableMethod(ProductCatogery.class,config, UnsupportedActions);
        DisableMethod(State.class,config, UnsupportedActions);
        DisableMethod(Country.class,config, UnsupportedActions);





        exposeIds(config);
    }

    private static void DisableMethod(Class theClass ,RepositoryRestConfiguration config, HttpMethod[] UnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass).withItemExposure((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(UnsupportedActions)));

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

