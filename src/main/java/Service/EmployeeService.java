package Service;
import Entities.Employee;
import DAO.DAO;
import DAO.EmployeeDao;
import java.util.List;
public class EmployeeService implements Service<Employee> {
    private DAO dao=new EmployeeDao();


    @Override
    public void saveEntity(Employee employee) {
        dao.save(employee);
    }

    @Override
    public void updateEntity(Employee employee) {
        dao.update(employee);
    }

    @Override
    public void deleteEntity(Employee employee) {
        dao.delete(employee);
    }

    @Override
    public List<Employee> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Employee findEntity(int id) {
        return (Employee) dao.findById(id);
    }
}

