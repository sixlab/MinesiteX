///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
// * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/10/8 22:07
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.mine.site.base.zuul.security;
//
//import cn.sixlab.mine.site.base.zuul.util.ReqContextUtil;
//import cn.sixlab.mine.site.core.ModelJson;
//import com.netflix.zuul.ZuulFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class ApiAuthFilter extends ZuulFilter {
//
//    @Autowired
//    private MsUser msUser;
//
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        if (ReqContextUtil.isContinue()) {
//            HttpServletRequest request = ReqContextUtil.getRequest();
//            String uri = request.getRequestURI();
//
//            if (uri.startsWith("/api/")) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Object run() {
//        HttpServletRequest request = ReqContextUtil.getRequest();
//
//        String accessToken = request.getHeader("accessToken");
//
//        boolean login = false;
//        if (!StringUtils.isEmpty(accessToken)) {
//            login = true;
//            request.setAttribute("loginUser", msUser);
//        }
//
//        String uri = request.getRequestURI();
//
//        if (!login && !uri.contains("/pub/")) {
//            ReqContextUtil.setError(new ModelJson().setErrorMessage("未登录", 10000));
//        }
//
//        return null;
//    }
//}
