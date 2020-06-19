package com.curso.spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.spring.domain.model.Client;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  //List<Client> findByName(String name);

}
