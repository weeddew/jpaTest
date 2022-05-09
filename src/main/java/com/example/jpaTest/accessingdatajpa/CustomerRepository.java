package com.example.jpaTest.accessingdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, String>, QuerydslPredicateExecutor<Customer> {

  List<Customer> findByName(String name);
  
  Optional<Customer> findById(String id);
  
  //@Query(value="select a from Customer a left join a.code c where c.name = ?1")
  @Query(value="select * from ZZ_TEST a left outer join ZZ_TEST2 b on a.code = b.code where b.name = ?1", nativeQuery = true)
  List<Customer> findByCodeName(String name);
}