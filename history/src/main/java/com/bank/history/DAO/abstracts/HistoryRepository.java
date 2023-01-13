package com.bank.history.DAO.abstracts;

import com.bank.history.models.History;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository {

    void save(History history);

    Optional<History> getById(Long id);

    List<History> getAllHistories();

    void update(History history);

}
