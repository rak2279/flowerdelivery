
package flowerdelivery;

public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long orderID;
    private Long ordermanagementId;
    private String deliveryStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderID;
    }

    public void setOrderId(Long orderID) {
        this.orderID = orderID;
    }
    public Long getOrdermanagementId() {
        return ordermanagementId;
    }

    public void setOrdermanagementId(Long ordermanagementId) {
        this.ordermanagementId = ordermanagementId;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}

