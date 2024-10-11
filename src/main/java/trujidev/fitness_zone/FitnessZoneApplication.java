package trujidev.fitness_zone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trujidev.fitness_zone.model.Customer;
import trujidev.fitness_zone.service.ICustomerService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FitnessZoneApplication implements CommandLineRunner {
	@Autowired
	private ICustomerService customerService;

	private static final Logger logger = LoggerFactory.getLogger(FitnessZoneApplication.class);

	public static void main(String[] args) {
		logger.info("Application started");
		SpringApplication.run(FitnessZoneApplication.class, args);
		logger.info("Application finished");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n*** Fitness Zone App ***");
		fitnessZoneApp();
	}

	private void fitnessZoneApp() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);

		while (!exit) {
			try {
				var option = showMenu(sc);
				exit = executeOptions(sc, option);
			} catch (Exception e) {
        logger.info("An error occurred while executing the selected option: {}", e.getMessage());
        logger.info("Exception type: {}", e.getClass().getName());
        logger.info("Exception parent class: {}", e.getClass().getSuperclass().getName());
			}
		}
	}

	private int showMenu(Scanner sc) {
		logger.info("""
				1. Customer list
				2. Find a customer
				3. Add a customer
				4. Update a customer
				5. Delete a customer
				6. Exit
				Select an option:\s""");
		return Integer.parseInt(sc.nextLine());
	}

	private boolean executeOptions(Scanner sc, int option) {
		return switch (option) {
			case 1 -> {
				logger.info("\n--- Customer list ---");

				List<Customer> customers = customerService.getCustomers();
				customers.forEach(customer -> logger.info(customer.toString()));

				yield false;
			}
			case 2 -> {
				logger.info("\n--- Find a customer ---");

				logger.info("Type the ID of the user you want to search for: ");
				var id = Integer.parseInt(sc.nextLine());

				var customer = customerService.getCustomerById(id);

				if (customer != null) {
          logger.info("\nCustomer found: \n{}", customer);
				} else {
          logger.info("\nCustomer with ID {} was not found.", id);
				}

				yield false;
			}
			case 3 -> {
				logger.info("\n--- Add a customer ---");

				logger.info("Type the user's name: ");
				var name = sc.nextLine();

				logger.info("Type the user's lastname: ");
				var lastname = sc.nextLine();

				logger.info("Is the user a member?: ");
				var membership = sc.nextBoolean();

				var customer = new Customer();
				customer.setName(name);
				customer.setLastname(lastname);
				customer.setMembership(membership);

				customerService.createCustomer(customer);
				logger.info("Aggregate customer.");

				yield false;
			}
			case 4 -> {
				logger.info("\n--- Update a customer ---");

				System.out.print("Type the user's ID: ");
				var id = Integer.parseInt(sc.nextLine());

				var customer = customerService.getCustomerById(id);

				if (customer != null) {
					logger.info("Name: ");
					var name = sc.nextLine();

					logger.info("Lastname: ");
					var lastname = sc.nextLine();

					logger.info("Membership: ");
					var membership = sc.nextBoolean();

					customer.setName(name);
					customer.setLastname(lastname);
					customer.setMembership(membership);

					customerService.createCustomer(customer);

          logger.info("Updated customer: {}", customer);
				}

				yield false;
			}
			case 5 -> {
				logger.info("\n--- Delete a customer ---");

				System.out.print("Enter the ID of the customer you wish to delete: ");
				var id = Integer.parseInt(sc.nextLine());

				var customer = customerService.getCustomerById(id);

				if (customer != null) {
					customerService.deleteCustomer(customer);
					logger.info("Customer deleted.\n");
				} else {
          logger.info("Customer not found.");
				}

				yield false;
			}
			case 6 -> {
				logger.info("Leaving...");
				yield true;
			}
			default -> throw new IllegalStateException("Unexpected value: " + option);
		};
	}
}
