package com.zgc.aspect;

import com.alibaba.fastjson.JSONObject;
import com.base.annotation.Log;
import com.base.util.NetUtil;
import com.zgc.model.SysLog;
import com.zgc.model.User;
import com.zgc.service.ISysLogService;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @program: CTW
 * @description: 系统日志切面
 * @author: laoyangtou
 * @create: 2018-08-13 14:17
 **/
//@Aspect
//@Component
public class SystemLogAspect {
    @Autowired
    ISysLogService sysLogService;

    // 第一个*表示匹配任意的方法返回值，第二个*表示所有类,第三个*表示所有方法，
    // 第一个..表示action包及其子包,第二个..表示方法的任意参数个数
    @Pointcut("execution (* com.zgc.action..*.*(..))")
    public  void Aspect1() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint 切点
     */
    @Before("Aspect1()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行前置通知===============");
    }

    //配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("Aspect1()")
    public void around(JoinPoint joinPoint){
        System.out.println("==========开始执行环绕通知===============");
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            System.out.println("==========结束执行环绕通知===============");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 后置通知
     *
     * @param joinPoint 切点
     */
    @After("Aspect1()")
    public  void after(JoinPoint joinPoint) {

        HttpServletRequest request =  ServletActionContext.getRequest();
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
        //模拟一个登录用户的信息
        User user = new User();
        user.setId(1);
        String ip = NetUtil.getIp(request);
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
//            Object[] arguments = joinPoint.getArgs();
            Class  targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
//                    Class[] clazzs = method.getParameterTypes();
//                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        break;
//                    }
                }
            }
            //*========控制台输出=========*//
            System.out.println("=====后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()")+"."+operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人id:" + user.getId());
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//
            SysLog log = new SysLog();
            log.setUser_id(user.getId());
            log.setDescription(operationName);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);
            log.setIp(ip);
            log.setBroswer(NetUtil.getOsAndBrowserInfo(request));
            log.setOs(NetUtil.osName());
            //保存数据库
            sysLogService.save(log);
            System.out.println("=====后置通知结束=====");
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    //配置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("Aspect1()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("=====执行返回通知=====");
    }

    /**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "Aspect1()", throwing="e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request =  ServletActionContext.getRequest();
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
        String ip =  NetUtil.getIp(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        User user = new User();
        user.setId(1);
        String params = "";

        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                params += JSONObject.toJSONString(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        break;
                    }
                }
            }
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()")+"."+operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人id:" + user.getId());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            /*==========数据库日志=========*/
            SysLog log = new SysLog();
            log.setUser_id(user.getId());
            log.setDescription(operationName);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setIp(ip);
            log.setBroswer(NetUtil.getOsAndBrowserInfo(request));
            log.setOs(NetUtil.osName());
            //保存数据库
            sysLogService.save(log);
            System.out.println("=====异常通知结束=====");
        }  catch (Exception ex) {
            e.printStackTrace();
        }
        /*==========记录本地异常日志==========*/
       System.out.println("异常方法:{}异常代码:{}异常信息:{}参数:{}"+joinPoint.getTarget().getClass().getName()
               +"  "+ joinPoint.getSignature().getName() + "  " + e.getClass().getName() +  "  " + e.getMessage()+params);

    }
}
