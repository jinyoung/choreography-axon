package choreography.axon.event;



import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ExchangeSucceededEvent {

    private Long orderId;
    private String userId;
    private Long currencyId;
    private Long amount;
    private Double rate;
    private Double pointUsed;

}
