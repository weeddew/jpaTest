package com.example.jpaTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jpaTest.accessingdatajpa.Customer;
import com.example.jpaTest.accessingdatajpa.CustomerRepository;
import com.example.jpaTest.accessingdatajpa.QCustomer;
import com.querydsl.core.types.Predicate;

/*
 * 
 * https://spring.io/guides/gs/accessing-data-jpa/
 * 

CREATE TABLE ZZ_TEST 
( 
    ID       VARCHAR2(10),
    NAME       VARCHAR2(10),
    CODE       VARCHAR2(10)

);

CREATE TABLE ZZ_TEST2 
( 
    CODE       VARCHAR2(10),
    NAME       VARCHAR2(10)

);

insert into zz_test values ('hslee','이후성','code1');
insert into zz_test values ('admin','관리자','code2');
insert into zz_test values ('gdhong','홍길동','code1');
insert into zz_test values ('gshong','홍길순','code4');
insert into zz_test values ('nobody','아무개',null);

insert into zz_test2 values ('code1','코드1');
insert into zz_test2 values ('code2','코드2');
insert into zz_test2 values ('code3','코드3');
insert into zz_test2 values ('code4','코드4');
*/

@SpringBootApplication
public class JpaTestApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaTestApplication.class);

	  public static void main(String[] args) {
	    SpringApplication.run(JpaTestApplication.class);
	  }

	  @Bean
	  public CommandLineRunner demo(CustomerRepository repository) {
	    return (args) -> {
	    	
	    	
	    	// QueryDSL
//	    	Predicate p = QCustomer.customer.code.name.contains("코드1");
//	    	for (Customer customer : repository.findAll(p)) {
//		        log.info(customer.toString());
//	    	}
	    	
	    	// JPQL or nativeQuery
	    	for (Customer customer : repository.findByCodeName("코드1")) {
	    		log.info(customer.toString());
	    	}
	    };
	  }
}
