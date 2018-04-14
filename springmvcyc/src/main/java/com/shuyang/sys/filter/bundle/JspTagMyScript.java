package com.shuyang.sys.filter.bundle;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class JspTagMyScript extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext=(PageContext)this.getJspContext();
        ServletRequest request = pageContext.getRequest();
        String ip=request.getRemoteHost();
        JspWriter out = pageContext.getOut();
        out.write("使用自定义标签展示客户ip地址"+ip);
        List<String> a=null;
    }

}
