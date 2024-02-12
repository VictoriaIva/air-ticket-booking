package Service;

import Entities.Passenger;
import DAO.DAO;
import DAO.PassengerDao;
import java.util.List;

public class PassengerService implements Service<Passenger> {
    private DAO dao=new PassengerDao();
    @Override
    public void saveEntity(Passenger passenger) {
        dao.save(passenger);
    }

    @Override
    public void updateEntity(Passenger passenger) {
        dao.update(passenger);
    }

    @Override
    public void deleteEntity(Passenger passenger) {
        dao.delete(passenger);
    }

    @Override
    public List<Passenger> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Passenger findEntity(int id) {
        return (Passenger) dao.findById(id);
    }
}

