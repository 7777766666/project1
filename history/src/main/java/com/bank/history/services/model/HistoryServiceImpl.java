package com.bank.history.services.model;

import com.bank.history.DAO.abstracts.HistoryRepository;
import com.bank.history.models.History;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public History getById(Long id) {
        Optional<History> history = historyRepository.getById(id);
        if (history.isEmpty()) {
            return null;
        }
        return history.get();
    }

    @Override
    public List<History> getAllHistories() {
        return historyRepository.getAllHistories();
    }

    @Override
    @Transactional
    public void update(Long id, History history) {
        Optional<History> history1 = historyRepository.getById(id);
        if (history1.isPresent()) {
            History history2 = history1.get();


            history2.setAuthorizationAuditId(history.getAuthorizationAuditId());
            history2.setAccountAuditId(history.getAccountAuditId());
            history2.setPublicBankInfoAuditId(history.getPublicBankInfoAuditId());
            history2.setProfileAuditId(history.getProfileAuditId());
            history2.setAntiFraudAuditId(history.getAntiFraudAuditId());
            history2.setTransferAuditId(history.getTransferAuditId());
            historyRepository.update(history2);
        }


    }
}
