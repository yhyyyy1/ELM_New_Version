package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.po.Orders;
import generator.service.OrdersService;
import generator.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author 14505
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-10-12 13:00:40
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




