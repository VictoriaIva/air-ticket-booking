package Service;
import Entities.User;
import DAO.DAO;
import DAO.UserDao;
import java.util.List;
public class UserService implements Service<User>{
    private DAO dao=new UserDao();
    @Override
    public void saveEntity(User user) {
        dao.save(user);
    }
    @Override
    public void updateEntity(User user) {
        dao.update(user);
    }

    @Override
    public void deleteEntity(User user) {
        dao.delete(user);
    }

    @Override
    public User findEntity(int id) {
        return (User) dao.findById(id);
    }

    @Override
    public List<User> findAllEntities() {
        return dao.findAll();
    }
}

