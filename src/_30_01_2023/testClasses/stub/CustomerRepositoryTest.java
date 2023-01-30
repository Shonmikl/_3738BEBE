package _30_01_2023.testClasses.stub;

import _30_01_2023.mockClasses.stub.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyLong;

public class CustomerRepositoryTest {

    @Test
    void testInvalidCustomer() {
        Customer customer = new Customer();
        CustomerRepository customerRepository =
                Mockito.mock(CustomerRepository.class);
        Mockito.when(customerRepository.getCustomerById(anyLong()))
                .thenThrow(new CustomerNotFoundException());

        CustomerService customerService =
                new SimpleCustomerService(customerRepository);
        Assertions.assertThrows(CustomerNotFoundException.class,
                () -> customerService.getCustomerById(customer.getId()));
    }
}