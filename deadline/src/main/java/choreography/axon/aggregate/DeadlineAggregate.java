package choreography.axon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.*;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date; 


import choreography.axon.command.*;
import choreography.axon.event.*;

@Aggregate
public class DeadlineAggregate {

    @AggregateIdentifier
    private Long id;
    private Date deadline;
    private Long orderId;
    private Date startedTime;

    public DeadlineAggregate(){}







    @EventSourcingHandler
    public void on(DeadlineReachedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Date getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }


}
