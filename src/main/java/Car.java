import java.util.Set;

public class Car {
    public int id;
    public Engine engine;
    public Set<Driver> drivers;

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Car(int id, Engine engine, Set<Driver> drivers) {
        this.id = id;
        this.engine = engine;
        this.drivers = drivers;
    }
    public Car() {

    }
    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Engine getEngineId() {
        return engine;
    }

}
