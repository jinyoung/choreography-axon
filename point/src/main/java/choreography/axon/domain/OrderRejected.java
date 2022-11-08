package choreography.axon.domain;

import choreography.axon.domain.*;
import choreography.axon.infra.AbstractEvent;
import java.util.Date;

public class OrderRejected extends AbstractEvent {

    private Long id;
    private String currencyId;
    private Double amount;
    private String holderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }
}

