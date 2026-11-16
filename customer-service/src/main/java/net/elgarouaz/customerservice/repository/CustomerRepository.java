package net.elgarouaz.customerservice.repository;

import net.elgarouaz.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
