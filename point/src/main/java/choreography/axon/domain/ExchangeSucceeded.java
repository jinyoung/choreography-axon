package choreography.axon.domain;

import choreography.axon.domain.*;
import choreography.axon.infra.AbstractEvent;
import java.util.Date;

public class ExchangeSucceeded extends AbstractEvent {

    private Long orderId;
    private String userId;
    private Long currencyId;
    private Long amount;
    private Double rate;
    private Double pointUsed;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    public Double getPointUsed() {
        return pointUsed;
    }

    public void setPointUsed(Double pointUsed) {
        this.pointUsed = pointUsed;
    }
}

