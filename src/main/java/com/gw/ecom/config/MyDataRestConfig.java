package com.gw.ecom.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.gw.ecom.entity.Product;
import com.gw.ecom.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;

	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] thUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((metadata,httpMethods) -> httpMethods.disable(thUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(thUnsupportedActions));
		
		config.getExposureConfiguration().forDomainType(ProductCategory.class).withItemExposure((metadata,httpMethods) -> httpMethods.disable(thUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(thUnsupportedActions));
		
		exposeIds(config);
	}
	
	public void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entites = entityManager.getMetamodel().getEntities();
		
		List<Class> entityClasses = new ArrayList<>();
		
		for(EntityType tempentityType: entites) {
				entityClasses.add(tempentityType.getJavaType());
		}
		
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);	
	}
	
}
