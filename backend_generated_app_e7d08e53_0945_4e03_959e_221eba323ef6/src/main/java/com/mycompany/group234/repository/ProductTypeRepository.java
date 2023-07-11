package com.mycompany.group234.repository;


import com.mycompany.group234.model.ProductType;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ProductTypeRepository extends SimpleJpaRepository<ProductType, String> {
    private final EntityManager em;
    public ProductTypeRepository(EntityManager em) {
        super(ProductType.class, em);
        this.em = em;
    }
    @Override
    public List<ProductType> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"ProductType\"", ProductType.class).getResultList();
    }
}