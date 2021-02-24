package io.javabrains.springbootstarter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VEmployeesRepository extends CrudRepository<VEmployees, String> {
  
}