package com.soft1851.springboot.mbp.service.impl;

import com.soft1851.springboot.mbp.model.TUser;
import com.soft1851.springboot.mbp.mapper.TUserMapper;
import com.soft1851.springboot.mbp.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w_zw
 * @since 2020-04-16
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
