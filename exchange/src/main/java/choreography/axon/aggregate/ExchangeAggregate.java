package choreography.axon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.*;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;
import java.util.List;


import choreography.axon.command.*;
import choreography.axon.event.*;

@Aggregate
public class ExchangeAggregate {

    private Long currencyId;
    private Long amount;
    @AggregateIdentifier
    private Long orderId;
    private Double rate;
    private Double pointUsed;

    public ExchangeAggregate(){}

    @CommandHandler
    public void handle(ExchangeCommand command){
        ExchangeSucceededEvent event = new ExchangeSucceededEvent();
        BeanUtils.copyProperties(command, event);     
        apply(event);

    }

    @CommandHandler
    public void handle(CompensateCommand command){
        ExchangeFailedEvent event = new ExchangeFailedEvent();
        BeanUtils.copyProperties(command, event);     
        apply(event);

        // ExchangeCompensatedEvent event = new ExchangeCompensatedEvent();
        // BeanUtils.copyProperties(command, event);     
        // apply(event);

    }



    @EventSourcingHandler
    public void on(ExchangeSucceededEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    @EventSourcingHandler
    public void on(ExchangeFailedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    @EventSourcingHandler
    public void on(ExchangeCompensatedEvent event) {
        BeanUtils.copyProperties(event, this);
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
