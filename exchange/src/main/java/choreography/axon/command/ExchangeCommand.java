package choreography.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


public class ExchangeCommand {

    private Long currencyId;
    private Long amount;
    @TargetAggregateIdentifier
    private Long orderId;
    private Double rate;
    private Double pointUsed;

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
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
