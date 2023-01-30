package _30_01_2023.mockClasses.stub;

public class SimpleCustomerService implements CustomerService {

	CustomerRepository customerRepository;

	public SimpleCustomerService(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
		
	}
}