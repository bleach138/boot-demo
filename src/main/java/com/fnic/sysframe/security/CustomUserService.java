package com.fnic.sysframe.security;

import com.fnic.mybatis.dao.TUserMapper;
import com.fnic.mybatis.model.TUser;
import com.fnic.mybatis.model.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by hjhuang on 2017/2/7.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<TUser> list = userMapper.selectByExample(example);

        if(list.size()>0) {
            TUser user = list.get(0);
            SysUser sysUser = new SysUser();
            sysUser.setId(user.getId());
            sysUser.setPassword(user.getPassword());
            sysUser.setAccountId(user.getAccountId());
            sysUser.setUserGroupId(user.getUserGroupId());
            sysUser.setEmail(user.getEmail());
            sysUser.setUsername(user.getUsername());

            return sysUser;
        }else {
            throw new UsernameNotFoundException("用户不存在");

        }
    }
}
