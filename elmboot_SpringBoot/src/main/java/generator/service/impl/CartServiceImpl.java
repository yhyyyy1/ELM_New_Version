package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.po.Cart;
import generator.service.CartService;
import generator.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author 14505
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2023-10-12 13:00:55
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




