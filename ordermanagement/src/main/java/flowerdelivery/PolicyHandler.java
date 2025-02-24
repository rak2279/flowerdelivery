package flowerdelivery;

import flowerdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
public class PolicyHandler{
	@Autowired(required=true)
	private OrdermanagementRepository orderManagementRepository;
	
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_AcceptRequest(@Payload Paid paid){

        if(paid.isMe()){
            System.out.println("##### listener AcceptRequest : " + paid.toJson());
            System.out.println("paid 주문 발생");
            System.out.println("주문 번호: "+ paid.getOrderId());
            Ordermanagement ordermanagement= new Ordermanagement();
           
           
//            ordermanagement.setOrderId(paid.getOrderId());
           ordermanagement.setOrdermanagementStatus(null);
            ordermanagement.setPaymentStatus(paid.getPaymentStatus());
            ordermanagement.setQty(paid.getQty());
            ordermanagement.setStoreName(paid.getStoreName());
           ordermanagement.setUserName(null);
           ordermanagement.setItemName("Flower");
            System.out.println("adding " +ordermanagement);
//            orderManagementRepository.save(ordermanagement);
            orderManagementRepository.save(ordermanagement);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled_AcceptCancel(@Payload PaymentCanceled paymentCanceled){

        if(paymentCanceled.isMe()){
            System.out.println("##### listener AcceptCancel : " + paymentCanceled.toJson());
            System.out.println("paymentCanceled 주문 발생");
            System.out.println("주문 번호: "+ paymentCanceled.getOrderId());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted_UpdateOrdermanagementStatus(@Payload DeliveryCompleted deliveryCompleted){

        if(deliveryCompleted.isMe()){
            System.out.println("##### listener UpdateOrdermanagementStatus : " + deliveryCompleted.toJson());
            System.out.println("deliveryCompleted 주문 발생");
            System.out.println("주문 번호: "+ deliveryCompleted.getOrderId());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDepartedForDelivery_UpdateOrdermanagementStatus(@Payload DepartedForDelivery departedForDelivery){

        if(departedForDelivery.isMe()){
            System.out.println("##### listener UpdateOrdermanagementStatus : " + departedForDelivery.toJson());
            System.out.println("DepartedForDelivery 주문 발생");
            System.out.println("주문 번호: "+ departedForDelivery.getOrderId());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_UpdateOrdermanagementStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(deliveryCanceled.isMe()){
            System.out.println("##### listener UpdateOrdermanagementStatus : " + deliveryCanceled.toJson());
            System.out.println("deliveryCanceled 주문 발생");
            System.out.println("주문 번호: "+ deliveryCanceled.getOrderId());
        }
    }

}
