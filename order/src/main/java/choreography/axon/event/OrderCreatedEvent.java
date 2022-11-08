package choreography.axon.event;

import lombok.Data;
import lombok.ToString;



@ToString
@Data
public class OrderCreatedEvent {

    private Long id;
    private String currencyId;
    private Double amount;
    private String holderId;

}
