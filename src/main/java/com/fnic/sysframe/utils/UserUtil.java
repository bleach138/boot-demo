package com.fnic.sysframe.utils;

import com.fnic.sysframe.security.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by hjhuang on 2017/5/19.
 */
public class UserUtil {

    public static SysUser getUser() {
        SysUser userDetails = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails;
    }

}
