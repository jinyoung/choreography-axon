package choreography.axon.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import choreography.axon.command.*;
import choreography.axon.event.*;
import choreography.axon.aggregate.*;

@Service
@ProcessingGroup("order_Policy")
public class PolicyHandler{

    @EventHandler
    public void wheneverExchangeFailed_(ExchangeFailedEvent exchangeFailed){
        System.out.println(exchangeFailed.toString());
    }
    @EventHandler
    public void wheneverDeadlineReached_(DeadlineReachedEvent deadlineReached){
        System.out.println(deadlineReached.toString());
    }
    @EventHandler
    public void wheneverPointUseFailed_(PointUseFailedEvent pointUseFailed){
        System.out.println(pointUseFailed.toString());
    }
    @EventHandler
    public void wheneverPointUsed_(PointUsedEvent pointUsed){
        System.out.println(pointUsed.toString());
    }

}
