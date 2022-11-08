package choreography.axon.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;


@RestController
public class OrderStatusQueryController {

  private final QueryGateway queryGateway;

  public ViewController(QueryGateway queryGateway) {
      this.queryGateway = queryGateway;
  }
  

  @GetMapping("/orderStatuses")
  public CompletableFuture<List<OrderStatus>> findAll() {
      return queryGateway.query(new OrderStatusQuery(), ResponseTypes.multipleInstancesOf(OrderStatus.class));
  }

}

