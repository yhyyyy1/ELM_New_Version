package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.po.Business;
import generator.service.BusinessService;
import generator.mapper.BusinessMapper;
import org.springframework.stereotype.Service;

/**
* @author 14505
* @description 针对表【business】的数据库操作Service实现
* @createDate 2023-10-12 13:00:59
*/
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
    implements BusinessService{

}




