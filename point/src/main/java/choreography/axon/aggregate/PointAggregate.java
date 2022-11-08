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
public class PointAggregate {

    private Double point;
    @AggregateIdentifier
    private String userId;

    public PointAggregate(){}







    @EventSourcingHandler
    public void on(PointUsedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    @EventSourcingHandler
    public void on(PointUseFailedEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
