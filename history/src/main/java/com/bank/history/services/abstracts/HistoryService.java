package com.bank.history.services.abstracts;

import com.bank.history.models.History;

import java.util.List;

public interface HistoryService {

    void save(History history);

    History getById(Long id);

    List<History> getAllHistories();

    void update(Long id, History history);
}
