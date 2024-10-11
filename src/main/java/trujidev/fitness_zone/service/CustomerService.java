package trujidev.fitness_zone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trujidev.fitness_zone.model.Customer;
import trujidev.fitness_zone.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(Integer id) {
    return customerRepository.findById(id).orElse(null);
  }

  @Override
  public void createCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(Customer customer) {
    customerRepository.delete(customer);
  }
}
