package com.example.jpaTest.accessingdatajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ZZ_TEST")
public class Customer {

	@Id
@Column(name = "ID")
  private String id;

@Column(name = "NAME")
  private String name;

@ManyToOne
@JoinColumn(name = "CODE") 
private Code code;

  protected Customer() {}

  public Customer(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%s, firstName='%s', code='%s']",
        id, name, code);
  }

	public String getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}


  
}