import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestToDoListApp {
    @Test
    public void testGetEntities() {
        ToDoListApp listApp = ToDoListApp.getInstance();
        Driver driver = listApp.findByid(1, Driver.class);
        Engine engine = listApp.findByid(0, Engine.class);
        Car mycar = listApp.findByid(1, Car.class);
        Set<Driver> drivers = mycar.getDrivers();
        assertEquals(driver, new Driver(1));
        assertEquals(engine, new Engine(0));
    }

    @Test
    public void testAddEntities() {
        ToDoListApp listApp = ToDoListApp.getInstance();
        listApp.save(new Driver(12));
        assertEquals(listApp.findByid(12,Driver.class), new Driver(12));
    }
}
