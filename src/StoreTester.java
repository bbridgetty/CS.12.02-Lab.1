import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreTester {
        @Test
        public void addBookTest(){
            Store testStore = new Store();
            Book book = new Book();
            testStore.addBook(book);
            assertTrue(true);
        }
//aa
        @Test
        public void addBookAndPhoneTest(){
            Store testStore = new Store();
            Book book = new Book();
            Phone phone = new Phone();
            testStore.addBook(book);
            testStore.addPhone(phone);
            assertTrue(true);
        }
        @Test
        public void updatePhonesLocationTest(){
            Store testStore = new Store();
            Phone phone1 = new Phone();
            Phone phone2 = new Phone();
            testStore.addPhone(phone1);
            testStore.addPhone(phone2);
            testStore.updatePhonesLocation("Room 512");
            for (Phone phone : testStore.getAllPhones()) {
                assertEquals(phone.getLocation(), "Room 512");
            }
        }
    @Test
    public void testGetItems() {
        Store testStore = new Store();
        Book book = new Book();
        Phone phone = new Phone();
        testStore.addBook(book);
        testStore.addPhone(phone);

        ArrayList<CISItem> result = testStore.getItems("Book");

        assertEquals(1, result.size());
        assertEquals(book, result.get(0));

    }
    @Test
    public void updateItems(){
        Store testStore = new Store();
        Book book = new Book();
        Phone phone = new Phone();
        Magazine magazine = new Magazine();
        Arduino arduino = new Arduino();
        testStore.addBook(book);
        testStore.addPhone(phone);
        testStore.addMagazine(magazine);
        testStore.addArduino(arduino);

        testStore.updateItems("phone", "location", "Room 511");
        for (Phone phone1 : testStore.getAllPhones()) {
            assertEquals(phone.getLocation(), "Room 511");
        }

        testStore.updateItems("magazine", "location", "Room 514");
        for (Magazine magazine1: testStore.getAllMagazines()) {
            assertEquals(magazine.getLocation(), "Room 514");
        }

        testStore.updateItems("arduino", "location", "Room 314");
        for (Arduino arduino1: testStore.getAllArduinos()) {
            assertEquals(arduino.getLocation(), "Room 314");
        }
    }
}