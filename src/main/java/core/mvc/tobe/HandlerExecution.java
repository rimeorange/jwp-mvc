package core.mvc.tobe;

import core.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class HandlerExecution {

    private final Object instance;
    private final Method method;

    public HandlerExecution(Object instance, Method method) {
        this.instance = instance;
        this.method = method;
    }

    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: 왜 핸들러가 굳이 ModelAndView의 정체를 알아야하지??
        return (ModelAndView) method.invoke(instance, request, response);
    }
}
