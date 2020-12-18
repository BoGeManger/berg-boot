package com.berg.common.constant;

public class RedisKeyConstants {

    public static final class System {
        //授权TOKEN(token)
        public static final String SYSTEM_TOKEN = "system_token_%s";
        //用户角色信息(username)
        public static final String USER_ROLE = "user_role_%s";
        //用户组件权限信息(username)
        public static final String USER_PERMS = "user_perms_%s";
    }

    public static final class Request{
        //请求应用接口(name)
        public static final String APPLICATION_API = "application_api_%s";
    }

}
