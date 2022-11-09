package choreography.axon.query;


import choreography.axon.event.*;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@ProcessingGroup("orderStatus")
public class OrderStatusQueryHandler {

    private final Map<Long, OrderStatus> data = new HashMap<>();

    @QueryHandler
    public List<OrderStatus> handle(OrderStatusQuery query) {
        return new ArrayList<>(data.values());
    }

    @EventHandler
    public void on(OrderCreatedEvent orderCreated) {

    OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(orderCreated.getId());
        orderStatus.setCurrencyId(Long.valueOf(orderCreated.getCurrencyId()));
        orderStatus.setStatus("PENDING");

        data.put(orderStatus.getId(), orderStatus);
    }


    @EventHandler
    public void on(ExchangeSucceededEvent exchangeSucceeded) {
            // view 객체 조회
        OrderStatus orderStatus = data.getOrDefault(exchangeSucceeded.getOrderId(), null);

        if( orderStatus != null) {
                
            orderStatus.setStatus("EXCHANGED");    
            // view 레파지 토리에 save
                data.put(orderStatus.getId(), orderStatus);
            }


    }
    @EventHandler
    public void on(PointUsedEvent pointUsed) {
            // view 객체 조회
        OrderStatus orderStatus = data.getOrDefault(pointUsed.getOrderId(), null);

        if( orderStatus != null) {
                
            orderStatus.setStatus("APPROVED");    
            // view 레파지 토리에 save
                data.put(orderStatus.getId(), orderStatus);
            }


    }

}

