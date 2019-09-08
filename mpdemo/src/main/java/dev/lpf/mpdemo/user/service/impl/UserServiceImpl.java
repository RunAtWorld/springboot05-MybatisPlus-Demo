package dev.lpf.mpdemo.user.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.lpf.mpdemo.user.entity.User;
import dev.lpf.mpdemo.user.mapper.UserMapper;
import dev.lpf.mpdemo.user.service.IUserService;
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
