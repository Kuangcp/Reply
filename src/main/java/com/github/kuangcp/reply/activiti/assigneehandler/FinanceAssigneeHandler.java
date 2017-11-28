//package com.github.kuangcp.reply.activiti.assigneehandler;
//
//
//import org.activiti.engine.delegate.DelegateTask;
//import org.activiti.engine.delegate.TaskListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
///**
// * 财务任务候选.
// *
// * @author: huang
// * Date: 17-11-8
// */
//@Component
//public class FinanceAssigneeHandler implements TaskListener {
//
//    @Override
//    public void notify(DelegateTask delegateTask) {
//        LeaveBillRepository billRepository = SpringContextUtil.getBean("leaveBillRepository");
//        List<LeaveBill> bills = billRepository.findAll();
//        for (LeaveBill bill : bills) {
//            System.out.println(bill.getId());
//            delegateTask.addCandidateUser(bill.getId());
//        }
//    }
//}
