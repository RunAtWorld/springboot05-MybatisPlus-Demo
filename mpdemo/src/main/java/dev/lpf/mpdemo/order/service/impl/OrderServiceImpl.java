package dev.lpf.mpdemo.order.service.impl;

import dev.lpf.mpdemo.order.entity.Order;
import dev.lpf.mpdemo.order.mapper.OrderMapper;
import dev.lpf.mpdemo.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpf
 * @since 2019-09-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
