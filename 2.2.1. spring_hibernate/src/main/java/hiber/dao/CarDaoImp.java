package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> cars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createSQLQuery("FROM CAR");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void cleanCars() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Car").executeUpdate();
    }
}
