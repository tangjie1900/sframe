package cn.cout.pure.sframe.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WeblogAspect {

    private Logger logger = LoggerFactory.getLogger(WeblogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * cn.cout.pure.sframe..*.*(..))")
    public void webControllerPointCut() {

    }

    @Before("webControllerPointCut()")
    public void before(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();

        // url
        String url = servletRequest.getRequestURL().toString();
        // uri
        String uri = servletRequest.getRequestURI().toString();
        // HTTP_METHOD
        String method = servletRequest.getMethod();
        // ip
        String ip = servletRequest.getRemoteAddr();
        // host
        String host = servletRequest.getRemoteHost();
        // CLASS_METHOD
        String class_method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // args
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("url: " + url + " uri:" + uri + " method:" + method + " ip:" + ip + " host:" + host + " class_method :" + class_method + " args" + args);
    }

    @AfterReturning(returning = "ret", pointcut = "webControllerPointCut()")
    public void afterReturn(Object ret) {
        Long usedTime = System.currentTimeMillis() - startTime.get();
        logger.info("response: " + ret + " used :" + usedTime);
    }
}
