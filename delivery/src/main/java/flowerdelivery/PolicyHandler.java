package flowerdelivery;

import flowerdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDecorated_DeliveryRequest(@Payload Decorated decorated){

        if(decorated.isMe()){
            System.out.println("##### listener DeliveryRequest : " + decorated.toJson());
            System.out.println("decorated 주문 발생");
            System.out.println("주문 번호 : "+decorated.getOrderId());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRegistrationCanceled_DeliveryCancel(@Payload RegistrationCanceled registrationCanceled){

        if(registrationCanceled.isMe()){
            System.out.println("##### listener DeliveryCancel : " + registrationCanceled.toJson());
            System.out.println("registrationCanceled 주문 발생");
            System.out.println("주문 번호 : "+ registrationCanceled.getId());
        }
    }    

}
