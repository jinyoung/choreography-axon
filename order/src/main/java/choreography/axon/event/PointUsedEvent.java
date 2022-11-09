
package choreography.axon.event;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PointUsedEvent{

    private Long id;
    private Long userId;
    private Double point;
    private Long orderId;

}
