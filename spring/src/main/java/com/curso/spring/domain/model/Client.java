package com.curso.spring.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Client{
  @NotBlank
  @Size(max = 255)
  private String name;
  @NotBlank
  @Email
  @Size(max = 60)
  private String email;
  @Column(name = "telefone")
  @NotBlank
  @Size(max = 20)
  private String tel;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY) //use native form of sql
  private long id;

  public Client(){

  }

  public Client(String name , String email , String tel , long id){
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.id = id;
  }

  /* They are necess. */
  public String getName(){return name;}
  public long getId(){return id;}
  public String getEmail(){return email;}
  public String getTel(){return tel;}

  public void setId(Long id){this.id = id;}
  public void setName(String name){this.name = name;}
  public void setEmail(String email){this.email = email;}
  public void setTel(String tel){this.tel = tel;}

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
