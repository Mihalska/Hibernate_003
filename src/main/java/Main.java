import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setId(6);
        animal.setAge(9);
        animal.setName("Myrsik");
        animal.setTail(true);
        setFactory(animal);
    }
    public static void setFactory (Object o){
        try {

            SessionFactory factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
        } catch ( Exception exception){
            System.out.println( exception.toString());
        }

    }
}
