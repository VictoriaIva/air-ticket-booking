package Service;

import Entities.Flight;
import DAO.DAO;
import DAO.FlightDao;
import java.util.List;

public class FlightService implements Service<Flight>{
    private DAO dao=new FlightDao();
    @Override
    public void saveEntity(Flight flight) {
        dao.save(flight);
    }

    @Override
    public void updateEntity(Flight flight) {
        dao.update(flight);
    }

    @Override
    public void deleteEntity(Flight flight) {
        dao.delete(flight);
    }

    @Override
    public List<Flight> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Flight findEntity(int id) {
        return (Flight) dao.findById(id);
    }
}
