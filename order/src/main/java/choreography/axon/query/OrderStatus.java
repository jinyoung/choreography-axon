package choreography.axon.query;

import java.util.List;
import java.util.Date;
import lombok.Data;

@Data
public class OrderStatus {

        private Long id;
        private Long currencyId;
        private String status;


}