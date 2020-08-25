import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            System.out.println(tx.getStatus());
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }


    public <E> E save(E car) {
        return this.tx(session -> {
            session.save(car);
            return car;
        });
    }


    public <E> E findByid(Integer id,Class<E> cl) {
        return this.tx(session -> session.get(cl, id));
    }


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
