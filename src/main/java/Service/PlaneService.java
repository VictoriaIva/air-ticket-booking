package Service;
import Entities.Plane;
import DAO.DAO;
import DAO.PlaneDao;
import java.util.List;


public class PlaneService implements Service<Plane> {
    private DAO dao=new PlaneDao();
    @Override
    public void saveEntity(Plane plane) {
        dao.save(plane);
    }

    @Override
    public void updateEntity(Plane plane) {
        dao.update(plane);
    }

    @Override
    public void deleteEntity(Plane plane) {
        dao.delete(plane);
    }

    @Override
    public List<Plane> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Plane findEntity(int id) {
        return (Plane) dao.findById(id);
    }
}