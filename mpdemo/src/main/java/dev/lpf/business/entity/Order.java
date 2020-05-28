package dev.lpf.business.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author RunAtWorld
 * @since 2020-05-28
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String orderId;

    private String orderName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", userId=" + userId +
        ", orderId=" + orderId +
        ", orderName=" + orderName +
        "}";
    }
}
