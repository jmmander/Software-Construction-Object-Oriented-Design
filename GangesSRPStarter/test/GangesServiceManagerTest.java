package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the model.GangesServiceManager. These tests should pass with the starter code, and after successful refactoring.
 */

public class GangesServiceManagerTest {

    private PurchaseBook pb;
    private Customer customer;
    private DataStorage ds;
    private static final String NAME = "Crystal Shanda Lear";
    private static final String ADDR = "123 Waltz St";
    private static final int ID = 12345;

    @BeforeEach
    public void setup() {
        pb = new PurchaseBook();
        customer = new Customer(NAME, ADDR, ID);
        ds = new DataStorage();
    }

    @Test
    public void testNewCustomer() {
        Customer c = pb.signUpNewCustomer(ADDR, NAME);
        assertEquals(c.getName(), NAME);
        assertEquals(c.getAddress(), ADDR);
        assertTrue(c.getUniqueId() > 0);
    }

    @Test
    public void listAvaliableBooks() {
        pb.listAvailableBooks();
    }

    @Test
    public void orderBook() {
        BookOrder order = pb.orderBook(customer, 1);
        assertEquals(order.getCustomer(), customer);
        assertTrue(order.getOrderNumber() > 0);
    }

    @Test
    public void cancelOrder() {
        BookOrder order = pb.orderBook(customer, 1);
        assertTrue(pb.cancelBookOrder(order.getOrderNumber()));
        int fakeOrderNum = 5;
        assertFalse(pb.cancelBookOrder(fakeOrderNum));
    }

    @Test
    public void putAndGetNewData() {
        assertNull(ds.getData(customer));
        String dataString = "I am the very model of a modern major general";
        ds.putData(customer, dataString);
        assertEquals(ds.getData(customer), dataString);
    }

    @Test
    public void putDataOverwrite() {
        assertNull(ds.getData(customer));
        String dataString = "I've information vegetable animal and mineral";
        ds.putData(customer, dataString);
        assertEquals(ds.getData(customer), dataString);

        String newDataString = "I know the kings of England and I quote the fights historical";
        ds.putData(customer, newDataString);
        assertEquals(ds.getData(customer), newDataString);
    }

    @Test
    public void deleteData() {
        String dataString = "From Marathon to Waterloo in order categorical";
        ds.putData(customer, dataString);
        assertEquals(ds.getData(customer), dataString);

        ds.deleteData(customer);
        assertNull(ds.getData(customer));
    }
}
