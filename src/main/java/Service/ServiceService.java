package Service;

import DAO.DAO;
import DAO.ServiceDao;

import java.util.List;

public class ServiceService implements Service<Service>{
    private DAO dao=new ServiceDao();
    @Override
    public void saveEntity(Service service) {
        dao.save(service);
    }

    @Override
    public void updateEntity(Service service) {
        dao.update(service);
    }

    @Override
    public void deleteEntity(Service service) {
        dao.delete(service);
    }

    @Override
    public List<Service> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Service findEntity(int id) {
        return (Service) dao.findById(id);
    }
}
