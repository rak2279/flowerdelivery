
package flowerdelivery;

public class RegistrationCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrdermanagementId() {
        return orderId;
    }

    public void setOrdermanagementId(Long orderId) {
        this.orderId = orderId;
    }
}

