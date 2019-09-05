package dev.lpf.mpdemo.user.service.impl;

import dev.lpf.user.entity.User;
import dev.lpf.user.mapper.UserMapper;
import dev.lpf.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpf
 * @since 2019-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
