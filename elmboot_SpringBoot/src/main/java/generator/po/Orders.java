package generator.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 订单编号
     */
    @TableId(type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 订购日期
     */
    private String orderDate;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;

    /**
     * 送货地址编号
     */
    private Integer daId;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}