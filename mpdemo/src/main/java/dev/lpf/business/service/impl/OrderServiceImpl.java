package dev.lpf.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import dev.lpf.business.entity.Order;
import dev.lpf.business.mapper.OrderMapper;
import dev.lpf.business.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author RunAtWorld
 * @since 2020-05-28
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Order> page = this.page(
        new Page(),
        new QueryWrapper<Order>()
        );

        return new PageUtils(page);
    }
}
