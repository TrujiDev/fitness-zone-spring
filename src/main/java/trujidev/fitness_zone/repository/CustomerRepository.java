package trujidev.fitness_zone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trujidev.fitness_zone.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
