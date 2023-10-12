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
 * @TableName food
 */
@TableName(value ="food")
@Data
public class Food implements Serializable {
    /**
     * 食品编号
     */
    @TableId(type = IdType.AUTO)
    private Integer foodId;

    /**
     * 食品名称
     */
    private String foodName;

    /**
     * 食品介绍
     */
    private String foodExplain;

    /**
     * 食品图片
     */
    private String foodImg;

    /**
     * 食品价格
     */
    private BigDecimal foodPrice;

    /**
     * 所属商家编号
     */
    private Integer businessId;

    /**
     * 备注
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}