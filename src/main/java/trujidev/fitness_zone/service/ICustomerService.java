package trujidev.fitness_zone.service;

import trujidev.fitness_zone.model.Customer;

import java.util.List;

public interface ICustomerService {
  public List<Customer> getCustomers();
  public Customer getCustomerById(Integer id);
  public void createCustomer(Customer customer);
  public void deleteCustomer(Customer customer);
}
