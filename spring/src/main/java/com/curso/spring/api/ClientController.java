package com.curso.spring.api;

import com.curso.spring.domain.model.Client;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.curso.spring.domain.repository.ClientRepository;

import java.util.List;

@RestController
public class ClientController{

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping("/clients")
  public List<Client> list(){
    return clientRepository.findAll();
  }
}
