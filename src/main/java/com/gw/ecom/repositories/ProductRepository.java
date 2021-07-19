package com.gw.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gw.ecom.entity.Product;

//@RepositoryRestResource(collectionResourceRel = "product", path = "products")
@CrossOrigin("http://localhost:4100")
public interface ProductRepository extends JpaRepository<Product, Long>{

}
