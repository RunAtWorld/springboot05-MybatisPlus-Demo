package dev.lpf.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

import dev.lpf.business.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import dev.lpf.business.entity.User;
import dev.utils.PageUtils;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author RunAtWorld
 * @since 2020-05-28
 */
public interface IUserService extends IService<User> {
    PageUtils queryPage(Map<String, Object> params);
}
