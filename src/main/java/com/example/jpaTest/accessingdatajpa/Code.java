package com.example.jpaTest.accessingdatajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZZ_TEST2")
public class Code {

	@Id
@Column(name = "CODE")
  private String code;

@Column(name = "NAME")
  private String name;

  protected Code() {}

  public Code(String code, String name) {
    this.code = code;
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format(
        "Code[code=%s, codeName='%s']",
        code, name);
  }

public String getCode() {
	return code;
}


public String getName() {
	return name;
}

  
}