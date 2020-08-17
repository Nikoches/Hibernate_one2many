import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public class ToDoListApp  {
    private final static ToDoListApp toDoListApp = new ToDoListApp();
    private final static SessionFactory factory = HibernateUtils.getSessionFactory();

    private ToDoListApp() {
    }

    public static ToDoListApp getInstance() {
        return toDoListApp;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            e.getMessage();
        } finally {
            session.close();
        }
        return null;
    }


    public <T> T save(T car) {
        return this.tx(session -> {
            session.save(car);
            return car;
        });
    }


//    public <T> T findByid(Integer id) {
//        return this.tx(session -> session.get(Car.class, id));
//    }


    public <T> T update(T item) {
        return this.tx(session -> {
            session.update(item);
            return item;
        });
    }


    public <T> T delete(T id) {
        return this.tx(session -> {
            session.delete(id);
            return id;
        });
    }


    public List<Car> getAll() {
        return this.tx(
                session -> session.createQuery("From Car").list()
        );
    }
}
