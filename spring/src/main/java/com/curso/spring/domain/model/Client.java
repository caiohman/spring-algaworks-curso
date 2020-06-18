package com.curso.spring.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Client{
  private String name;
  private String email;
  @Column(name = "telefone")
  private String tel;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY) //use native form of sql
  private long id;

  public Client(String name , String email , String tel , long id){
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.id = id;
  }

/*
  getName
  getEmail
  getTel
*/
  public String getName(){return name;}
  public long getId(){return id;}

@Override
public int hashCode(){
  return this.name.charAt(0);
}

@Override
public boolean equals(Object obj){
  Client c = (Client) obj;
  return this.id == c.getId() && this.name.equals(c.getName());
}

}
