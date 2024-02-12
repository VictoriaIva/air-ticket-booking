package Service;

import Entities.Ticket;
import DAO.DAO;
import DAO.TicketDao;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TicketService implements Service<Ticket> {
    private DAO dao=new TicketDao();
    @Override
    public void saveEntity(Ticket ticket) {
        dao.save(ticket);
    }

    @Override
    public void updateEntity(Ticket ticket) {
        dao.update(ticket);
    }

    @Override
    public void deleteEntity(Ticket ticket) {
        dao.delete(ticket);
    }

    @Override
    public List<Ticket> findAllEntities() {
        return dao.findAll();
    }

    @Override
    public Ticket findEntity(int id) {
        return (Ticket) dao.findById(id);
    }
}
