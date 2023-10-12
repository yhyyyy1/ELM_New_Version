package generator.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName deliveryaddress
 */
@TableName(value ="deliveryaddress")
@Data
public class Deliveryaddress implements Serializable {
    /**
     * 送货地址编号
     */
    @TableId(type = IdType.AUTO)
    private Integer daId;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人性别
     */
    private Integer contactSex;

    /**
     * 联系人电话
     */
    private String contactTel;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 所属用户编号
     */
    private String userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}