package com.github.kuangcp.reply.activiti.assigneehandler;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 指定任务执行人.
 *
 * @author: huang
 * Date: 17-11-5
 */
@Slf4j
public class AssigneeHandler implements TaskListener{

    @Override
    public void notify(DelegateTask delegateTask) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("user");
        log.info(id);
        delegateTask.setAssignee(id);
    }
}
