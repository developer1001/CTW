package com.base.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.base.model.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public abstract class BaseAction<T> extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware {

    //接收参数id
    protected int id;
    //接收参数id字符串，例如"25,26,27"
    protected String ids;
    //接收一个实体对象
    protected T baseEntity;
    //接收一个page对象
    protected PageBean pageBean;

    protected HttpServletRequest httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected HttpSession httpSession;
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.httpSession = httpSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public T getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(T baseEntity) {
        this.baseEntity = baseEntity;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public void  writeJson(Object object){
        String json = JSON.toJSONString(object);
        System.out.print(json);
        HttpServletResponse response = getHttpServletResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * 禁止循环依赖
     * @param object
     */
    public void  writeJsonNofer(Object object){
        String json = JSON.toJSONString(object,SerializerFeature.DisableCircularReferenceDetect);
        System.out.print(json);
        HttpServletResponse response = getHttpServletResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
