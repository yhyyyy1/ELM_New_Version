package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.po.Food;
import generator.service.FoodService;
import generator.mapper.FoodMapper;
import org.springframework.stereotype.Service;

/**
* @author 14505
* @description 针对表【food】的数据库操作Service实现
* @createDate 2023-10-12 13:00:49
*/
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
    implements FoodService{

}




