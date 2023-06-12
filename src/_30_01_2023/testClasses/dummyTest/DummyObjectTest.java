package _30_01_2023.testClasses.dummyTest;

import _30_01_2023.mockClasses.dummy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//Dummy
public class DummyObjectTest {

    public Customer createDummy() {
        State state = new State("CA");
        City city = new City("Los Angeles", state);
        Address address = new Address("M avenue", city);
        return new Customer("Natallia", "Skiba", address);
    }

    // 1. Standard user case
    @Test
    public void addCustomerTest() {
        Customer dummy = createDummy();
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
    }

    //2. An exception
    @Test
    public void addNullCustomerTest() {
        Customer dummy = null;
        AddressBook addressBook = new AddressBook();
        Assertions.assertThrows(NullPointerException.class, () -> addressBook.addCustomer(dummy));
    }

    //3. Injecting Mock
    @Test
    public void addCustomerWithDummyTest() {
        Customer dummy = Mockito.mock(Customer.class);
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        Assertions.assertEquals(1, addressBook.getNumberOfCustomers());
    }
}