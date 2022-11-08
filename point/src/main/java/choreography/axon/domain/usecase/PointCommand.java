package choreography.axon.domain.usecase;

import choreography.axon.PointApplication;
import choreography.axon.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PointCommand{
    @Autowired
    PointRepository pointRepository;

}