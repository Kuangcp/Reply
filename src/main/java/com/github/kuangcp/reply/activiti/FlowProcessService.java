package com.github.kuangcp.reply.activiti;

import com.github.kuangcp.reply.activiti.model.BusinessKeyModel;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 流程服务接口.
 *
 * @author: huang
 * Date: 17-11-5
 */
public interface FlowProcessService {

    /**
     * 部署流程定义.
     * @param file zip文件
     * @param name 流程名
     */
    void deploy(MultipartFile file, String name) throws IOException;

    void deploy(String bpmnName, String pngName, String name);

    void deploy(String bpmnName, String name);

    /**
     * 启动流程实例.
     * @param key 流程键
     */
    ProcessInstance startProcess(String key);

    ProcessInstance startProcess(String key, String businessKey);

    ProcessInstance startProcess(String key, String businessKey, Map<String, Object> variable);

    /**
     * 启动流程实例并提交流程.
     * @param key 流程键
     * @param id 提交用户ID
     */
    void startProcessAndSubmit(String key, String id);

    void startProcessAndSubmit(String key, String businessKey, String id);

    void startProcessAndSubmit(String key, String businessKey, Map<String, Object> variable, String id);

    /**
     * 设置任务操作者.
     * @param taskId 任务ID
     * @param id 用户ID
     */
    void setAssignee(String taskId, String id);

    /**
     * 查询个人业务.
     * @param id 用户ID
     * @return 用户的个人业务
     */
    List<Task> getPersonTasks(String id);

    /**
     * 查询个人组任务中的任务
     * @param id 用户ID
     * @return 组任务
     */
    List<Task> getCandidateUserTasks(String id);

    /**
     * 拾取组任务任务.
     * @param taskId 任务ID
     * @param id 用户ID
     */
    void pickupTask(String taskId, String id);

    /**
     * 向组任务中添加成员.
     * @param taskId 任务ID
     * @param id 用户ID
     */
    void addForCandidateUser(String taskId, String id);

    void addForCandidateUser(String taskId, List<String> ids) throws Exception;

    /**
     * 将用户从组任务候选人中删除.
     * @param taskId 组任务ID
     * @param id 用户ID
     */
    void delForCandidateUser(String taskId, String id);

    /**
     * 通过任务ID获取businessKey.
     * @param taskId 任务编号
     * @return businessKey
     */
    BusinessKeyModel getBusinessKey(String taskId);

    /**
     * 完成任务.
     * @param taskId 任务ID
     * @param variable 参数
     */
    void complete(String taskId, Map<String, Object> variable);

    void complete(String taskId);

//    void complete(String taskId, String pass);

    /**
     * 是否已经完成流程.
     * @param processInstanceId 流程实例ID
     * @return true为流程已经完成，否则为未完成
     */
    boolean isCompleted(String processInstanceId);

    /**
     * 获取任务中的字符串型变量.
     * @param taskId 任务ID
     * @param key 变量键
     * @return 变量值
     */
    String getVariable(String taskId, String key);

    /**
     * 通过任务ID获取流程实例.
     * @param taskId 任务ID
     * @return 流程实例
     */
    ProcessInstance getProcessInstanceByTeskId(String taskId);

}
