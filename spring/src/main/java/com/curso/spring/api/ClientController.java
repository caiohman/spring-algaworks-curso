package com.curso.spring.api;

import com.curso.spring.domain.model.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import com.curso.spring.domain.repository.ClientRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/clients") //page base
public class ClientController{

  @Autowired //inection of dep.
  private ClientRepository clientRepository;

  @GetMapping
  public List<Client> list(){
    return clientRepository.findAll();
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<Client> search(@PathVariable Long clientId){
    Optional<Client> client = clientRepository.findById(clientId);

    if(client.isPresent())
      return ResponseEntity.ok(client.get()); //http status code 200

    return ResponseEntity.notFound().build(); //http status code 404
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)//http status code 201
  public Client add(@Valid @RequestBody Client client){
    return clientRepository.save(client);
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<Client> updateItem(@Valid @PathVariable Long clientId ,
   @RequestBody Client client){
    if(!clientRepository.existsById(clientId))
      return ResponseEntity.notFound().build();

    client.setId(clientId);
    client = clientRepository.save(client);

    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> remove(@PathVariable Long clientId){
    if(!clientRepository.existsById(clientId))
      return ResponseEntity.notFound().build();

    clientRepository.deleteById(clientId);
    return ResponseEntity.noContent().build(); //http status code 204
  }
}
