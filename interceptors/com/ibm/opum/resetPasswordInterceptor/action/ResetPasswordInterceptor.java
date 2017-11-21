package com.ibm.opum.resetPasswordInterceptor.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ibm.opum.util.action.ResetPasswordAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ResetPasswordInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(ResetPasswordAction.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

    	// invoke first intercepted action (ResetPasswordAction.resetPassword())
    	String result = invocation.invoke();
    	
    	// Do post processing after action
    	if ("passwordMismatch".equals(result)) {
    		ActionSupport action = (ActionSupport) invocation.getAction();
    		action.addActionError("Input in New Password does not match with input in Confirm New Password!");
    		return result;
    	}
    	return result;
    }
    
}