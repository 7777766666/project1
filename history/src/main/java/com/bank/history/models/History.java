package com.bank.history.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "transfer_audit_id")
    Long transferAuditId;
    @Column(name = "profile_audit_id")
    Long profileAuditId;
    @Column(name = "account_audit_id")
    Long accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    Long antiFraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    Long publicBankInfoAuditId;
    @Column(name = "authorization_audit_id")
    Long authorizationAuditId;

    public History(Long transferAuditId, Long profileAuditId, Long accountAuditId, Long antiFraudAuditId, Long publicBankInfoAuditId, Long authorizationAuditId) {
        this.transferAuditId = transferAuditId;
        this.profileAuditId = profileAuditId;
        this.accountAuditId = accountAuditId;
        this.antiFraudAuditId = antiFraudAuditId;
        this.publicBankInfoAuditId = publicBankInfoAuditId;
        this.authorizationAuditId = authorizationAuditId;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", transferAuditId=" + transferAuditId +
                ", profileAuditId=" + profileAuditId +
                ", accountAuditId=" + accountAuditId +
                ", antiFraudAuditId=" + antiFraudAuditId +
                ", publicBankInfoAuditId=" + publicBankInfoAuditId +
                ", authorizationAuditId=" + authorizationAuditId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) && Objects.equals(transferAuditId, history.transferAuditId) && Objects.equals(profileAuditId, history.profileAuditId) && Objects.equals(accountAuditId, history.accountAuditId) && Objects.equals(antiFraudAuditId, history.antiFraudAuditId) && Objects.equals(publicBankInfoAuditId, history.publicBankInfoAuditId) && Objects.equals(authorizationAuditId, history.authorizationAuditId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transferAuditId, profileAuditId, accountAuditId, antiFraudAuditId, publicBankInfoAuditId, authorizationAuditId);
    }
}


