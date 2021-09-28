package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext parentCtx=null,childCtx=null;
		DispatcherServlet servlet=null;
		ContextLoaderListener listener=null;
		ServletRegistration.Dynamic dyna=null;
		//create parent IOC Container
		parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		//create ContextLoaderListner and register with SerlvetConntainer
		listener=new ContextLoaderListener(parentCtx);
		ctx.addListener(listener);
		
		//create child IOC Container
				childCtx=new AnnotationConfigWebApplicationContext();
				childCtx.register(WebMVCAppConfig.class);
				//create DispatcherServlet and register with  ServletContainer
			servlet=new DispatcherServlet(childCtx);
			dyna=ctx.addServlet("ds",servlet);
			dyna.addMapping("*.htm");
			dyna.setLoadOnStartup(2);
	}//onStartup(-)
}//class