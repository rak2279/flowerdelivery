
package flowerdelivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="payment", url="http://localhost:8082")
public interface PaymentService {

    @RequestMapping(method= RequestMethod.POST, path="/payments")
    public void pay(@RequestBody Payment payment);

}