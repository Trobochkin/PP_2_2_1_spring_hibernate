package hiber.service;

import hiber.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiseImp implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public void clean() {
        carDao.cleanCars();
    }
}
