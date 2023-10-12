package generator.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName orderdetailet
 */
@TableName(value ="orderdetailet")
@Data
public class Orderdetailet implements Serializable {
    /**
     * 订单明细编号
     */
    @TableId(type = IdType.AUTO)
    private Integer odId;

    /**
     * 所属订单编号
     */
    private Integer orderId;

    /**
     * 食品编号
     */
    private Integer foodId;

    /**
     * 数量
     */
    private Integer quantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}