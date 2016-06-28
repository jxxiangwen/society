package cn.edu.shu.society.util;

import cn.edu.shu.society.enums.LoginEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by jxxia on 2016/6/28 0028.
 *
 */
public class RequestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);


    /**
     * 保存当前请求
     */
    public static void saveRequest(HttpServletRequest request) {
        request.getSession().setAttribute(LoginEnums.LAST_PAGE.getMsg(), RequestUtil.hashRequestPage(request));
        logger.debug("被拦截的url的sessionID:{}", request.getSession().getId());
        logger.debug("save request for {}", request.getRequestURI());
    }

    /**
     * 加密请求页面
     *
     * @param request
     * @return
     */
    public static String hashRequestPage(HttpServletRequest request) {
        String reqUri = request.getRequestURI();
        String query = request.getQueryString();
        if (query != null) {
            reqUri += "?" + query;
        }
        String targetPage = null;
        try {
            targetPage = Base64.encodeToString(reqUri.getBytes("UTF-8"), false);
        } catch (UnsupportedEncodingException ex) {
            //this does not happen
        }
        return targetPage;
    }

    /**
     * 取出之前保存的请求
     *
     * @return
     */
    public static String retrieveSavedRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return LoginEnums.REDIRECT_HOME.getMsg();
        }
        String HashedlastPage = (String) session.getAttribute(LoginEnums.LAST_PAGE.getMsg());
        if (HashedlastPage == null) {
            return LoginEnums.LOGIN_HOME.getMsg();
        } else {
            return retrieve(HashedlastPage);
        }
    }

    /**
     * 解密请求的页面
     *
     * @param targetPage
     * @return
     */
    public static String retrieve(String targetPage) {
        byte[] decode = Base64.decode(targetPage, true);
        try {
            String requestUri = new String(decode, "UTF-8");
            int i = requestUri.indexOf("/", 1);
            return requestUri.substring(i);
        } catch (UnsupportedEncodingException ex) {
            //this does not happen
            return null;
        }
    }
}
