import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestToDoListApp {
    @Test
    public void test(){
        ToDoListApp listApp = ToDoListApp.getInstance();
        Car car = new Car();
        car.setId(0);
        car.setEngine(new Engine(0));
        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver(0));
        car.setDrivers(drivers);
    }
}
