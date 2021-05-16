package flowerdelivery;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String storeName;
        private String itemName;
        private Integer orderQty;
        private Long itemPrice;
        private String orderStatus;
        private String deliveryStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }
        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
        public Integer getOrderQty() {
            return orderQty;
        }

        public void setOrderQty(Integer orderQty) {
            this.orderQty = orderQty;
        }
        public Long getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(Long itemPrice) {
            this.itemPrice = itemPrice;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

}
