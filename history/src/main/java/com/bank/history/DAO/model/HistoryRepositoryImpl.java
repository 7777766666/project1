package com.bank.history.DAO.model;

import com.bank.history.DAO.abstracts.HistoryRepository;
import com.bank.history.util.SingleResultUtil;
import com.bank.history.models.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(History history){
        entityManager.persist(history);
    }

    public Optional<History> getById(Long id){
        Optional<History> result = SingleResultUtil.getSingleResultOrNull(entityManager.createQuery("SELECT h from History h where h.id=:id", History.class)
                .setParameter("id", id));

        return result;
    }

    @Override
    public List<History> getAllHistories() {

        return  entityManager.createQuery("SELECT h FROM History h").getResultList();
    }

    @Override
    public void update(History history) {
        entityManager.merge(history);
    }


}
