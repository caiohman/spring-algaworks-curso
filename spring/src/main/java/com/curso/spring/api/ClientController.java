package com.curso.spring.api;

import com.curso.spring.domain.model.Client;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@RestController
public class ClientController{

  @GetMapping("/clients")
  public ArrayList<Client> list(){
    ArrayList<Client> clients = new ArrayList<Client>();
    clients.add(new Client("Joao" , "ab@ba.br" , "212121" , 1L));
    clients.add(new Client("Maria" , "bc@cb.br" , "313131" , 2L));

    return clients;
  }
}
