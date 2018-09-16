package com.shuyang.sys.security;

import com.shuyang.sys.component.pojo.UrlAuth;
import com.shuyang.sys.domain.mapper.MenuMapper;
import com.shuyang.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private MenuService menuService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    //tomcat启动时实例化一次
    public MyInvocationSecurityMetadataSource(MenuService menuService) {
        this.menuService = menuService;
        loadResourceDefine();
    }
    //tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
    private void loadResourceDefine() {
        resourceMap = new HashMap<>();
        Set<String> url = new HashSet<>();
        List<UrlAuth> authUrls = menuService.listAuthUrls();
        for (UrlAuth urlAuth : authUrls) {
            url.add(urlAuth.getUrl());
        }

        for (String string : url) {
            Collection<ConfigAttribute> configAttributes = new HashSet<>();
            for (UrlAuth urlAuth : authUrls) {
                if (string.equals(urlAuth.getUrl())) {
                    ConfigAttribute configAttribute = new SecurityConfig(urlAuth.getAuthority());
                    configAttributes.add(configAttribute);
                }
            }
            resourceMap.put(string, configAttributes);
        }
    }

    //参数是要访问的url，返回这个url对于的所有权限（或角色）
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 将参数转为url
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (resURL.equalsIgnoreCase(url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }
    @Override
    public boolean supports(Class<?>clazz) {
        return true;
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
