///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
// * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/10/9 18:06
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.mine.site.base.zuul.util;
//
//
//import cn.sixlab.mine.site.lib.core.ResponseUtil;
//import cn.sixlab.mine.site.lib.core.bean.ModelJson;
//import com.netflix.zuul.context.RequestContext;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class ReqContextUtil {
//
//    public static HttpServletRequest getRequest() {
//        return RequestContext.getCurrentContext().getRequest();
//    }
//
//    public static HttpServletResponse getResponse() {
//        return RequestContext.getCurrentContext().getResponse();
//    }
//
//    public static boolean isSkip() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        return ctx.getBoolean(ZuulConstants.FILTER_SKIP);
//    }
//
//    public static boolean isContinue() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        return !ctx.getBoolean(ZuulConstants.FILTER_SKIP);
//    }
//
//    public static void setError(int code, String msg) {
//        ModelJson json = new ModelJson().setErrorMessage(msg, code);
//        RequestContext ctx = RequestContext.getCurrentContext();
//
//        ResponseUtil.setJsonType(ctx.getResponse());
//
//        ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
//        ctx.setResponseStatusCode(200);// 返回错误码
//        ctx.setResponseBody(json.toString());// 返回错误内容
//        ctx.set(ZuulConstants.FILTER_SKIP, true);
//    }
//}
