package com.github.kuangcp.reply.activiti;

import com.github.kuangcp.reply.activiti.execption.CandidateUserEmptyException;
import com.github.kuangcp.reply.activiti.model.BusinessKeyModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * 流程服务实现类.
 * @author: huang
 * Date: 17-11-5
 */
@Service
@Slf4j
public class FlowProcessServiceImpl implements FlowProcessService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;

    @Override
    public void deploy(MultipartFile file, String name) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
        repositoryService.createDeployment()
                .name(name)
                .addZipInputStream(zipInputStream)
                .deploy();
    }

    @Override
    public void deploy(String bpmnName, String pngName, String name) {
        repositoryService.createDeployment()
                .name(name)
                .addClasspathResource(bpmnName)
                .addClasspathResource(pngName)
                .deploy();
    }

    @Override
    public void deploy(String bpmnName, String name) {
        repositoryService.createDeployment()
                .name(name)
                .addClasspathResource(bpmnName)
                .deploy();
    }

    @Override
    public ProcessInstance startProcess(String key) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        return processInstance;
    }

    @Override
    public ProcessInstance startProcess(String key, String businessKey) {
        businessKey = key + "." + businessKey;
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey);
        return processInstance;
    }

    @Override
    public ProcessInstance startProcess(String key, String businessKey, Map<String, Object> variable) {
        businessKey = key + "." + businessKey;
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variable);
        return processInstance;
    }

    @Override
    public void startProcessAndSubmit(String key, String id) {
        ProcessInstance processInstance = startProcess(key);
        Task task = getTask(processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
        String taskId = task.getId();
        setAssignee(taskId, id);
        Map<String, Object> map = new HashMap<>();
        int index = 0;
        map.put("index", index + 1);
        map.put("size", index + 1);
        map.put("" + index, id);
        complete(taskId, map);
    }

    private Task getTask(String processDefinitionId, String processInstanceId) {
        Task task = taskService.createTaskQuery()
                .processDefinitionId(processDefinitionId)
                .processInstanceId(processInstanceId)
                .singleResult();
        return task;
    }

    @Override
    public void startProcessAndSubmit(String key, String businessKey, String id) {
        ProcessInstance processInstance = startProcess(key, businessKey);
        Task task = getTask(processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
        String taskId = task.getId();
        setAssignee(taskId, id);
        Map<String, Object> map = new HashMap<>();
        int index = 0;
        map.put("index", index + 1);
        map.put("size", index + 1);
        map.put("" + index, id);
        complete(taskId, map);
    }

    @Override
    public void startProcessAndSubmit(String key, String businessKey, Map<String, Object> variable, String id) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variable);
        Task task = getTask(processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
        String taskId = task.getId();
        setAssignee(taskId, id);
        Map<String, Object> map = new HashMap<>();
        int index = 0;
        map.put("index", index + 1);
        map.put("size", index + 1);
        map.put("" + index, id);
        complete(taskId);
    }

    @Override
    public void setAssignee(String taskId, String id) {
        taskService.setAssignee(taskId, id);
    }


    @Override
    public List<Task> getPersonTasks(String id) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee(id)
                .orderByTaskCreateTime().desc()
                .list();
        return tasks;
    }

    @Override
    public List<Task> getCandidateUserTasks(String id) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateUser(id)
                .orderByTaskCreateTime().desc()
                .list();
        return tasks;
    }

    @Override
    public void pickupTask(String taskId, String id) {
        taskService.claim(taskId, id);
    }

    @Override
    public void addForCandidateUser(String taskId, String id) {
        taskService.addCandidateUser(taskId, id);
    }

    @Override
    public void addForCandidateUser(String taskId, List<String> ids) {
        if (ids != null && ids.size() > 0) {
            for (String id : ids) {
                taskService.addCandidateUser(taskId, id);
            }
            return;
        }
        throw new CandidateUserEmptyException();
    }

    @Override
    public void delForCandidateUser(String taskId, String id) {
        taskService.deleteCandidateUser(taskId, id);
    }

    @Override
    public BusinessKeyModel getBusinessKey(String taskId) {
        ProcessInstance processInstance = getProcessInstanceByTeskId(taskId);
        String businessKey = processInstance.getBusinessKey();
        String[] s = businessKey.split("\\.");
        if (s != null && s.length >1) {
            BusinessKeyModel model = new BusinessKeyModel(s[0], s[1]);
            return model;
        }
        return null;
    }

    @Override
    public void complete(String taskId, Map<String, Object> variable) {
        taskService.complete(taskId, variable);
        autoSetNowTaskAssignee(taskId);
    }

    @Override
    public void complete(String taskId) {
        taskService.complete(taskId);
        autoSetNowTaskAssignee(taskId);
    }

    private void autoSetNowTaskAssignee(String taskId) {
        ProcessInstance processInstance = getProcessInstanceByTeskId(taskId);
        String processDefinitionId = processInstance.getProcessDefinitionId();
        String processInstanceId = processInstance.getProcessInstanceId();
        Task task = getTask(processDefinitionId, processInstanceId);
        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .processInstanceId(processInstanceId)
                .taskName(task.getName())
                .orderByHistoricTaskInstanceStartTime().desc()
                .list();
        if (tasks != null) {
            String assign = tasks.get(0).getAssignee();
            taskService.setAssignee(task.getId(), assign);
        }
    }



    /*@Override
    public void complete(String taskId, String pass) {
        ProcessInstance processInstance = getProcessInstanceByTeskId(taskId);
        int index = getIndex(taskId);
        Map<String, Object> map = new HashMap<>();
        map.put("pass", pass);
        boolean reject = isReject(taskId);
        if (Variable.PASS_FALSE.equals(pass)) {
            String previous = getVariable(taskId, "" + (index - 1));
            int size = getSize(taskId);
            if (index >= size) {
                Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
                String assignee = task.getAssignee();
                if (!reject) {
                    map.put("size", ++size);
                    map.put("" + index, assignee);
                }
            }
            map.put("reject", true);
            map.put("index", index-1);
            complete(taskId, map);
            Task task = getTask(processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
            taskService.setAssignee(task.getId(), previous);
        }
        if (Variable.PASS_TRUE.equals(pass)) {
            boolean ok = isCompleted(processInstance.getProcessInstanceId());
            String assignee = null;
            int size = getSize(taskId);
            index++;
            if (!ok) {
                if (index >= size) {
                    Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
                    assignee = task.getAssignee();
                    if (!reject) {
                        size++;
                        map.put("size" , size);
                        map.put("index", index);
                        map.put("" + index, assignee);
                    } else {
                        map.put("reject", false);
                    }
                    complete(taskId, map);
                } else {
                    String next = getVariable(taskId, "" + index);
                    map.put("index", index);
                    complete(taskId, map);
                    if (!isCompleted(processInstance.getProcessInstanceId())) {
                        Task task = getTask(processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
                        taskService.setAssignee(task.getId(), next);
                    }
                }
            }
        }
    }*/

    @Override
    public boolean isCompleted(String processInstanceId) {
        boolean ok = true;
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
        if (processInstance != null) {
            ok = false;
        }
        return ok;
    }

    @Override
    public String getVariable(String taskId, String key) {
        return taskService.getVariable(taskId, key, String.class);
    }

    @Override
    public ProcessInstance getProcessInstanceByTeskId(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        return processInstance;
    }

    private Integer getIndex(String taskId) {
        return taskService.getVariable(taskId, "index", Integer.class);
    }

    private Integer getSize(String taskId) {
        return taskService.getVariable(taskId, "size", Integer.class);
    }

    private boolean isReject(String taskId) {
        Object object = taskService.getVariable(taskId, "reject");
        boolean reject = false;
        if (object != null) {
            reject = (boolean) object;
        }
        return reject;
    }

    public Comment addComment(String taskId, String processInstanceId, String message) {
        Comment comment = taskService.addComment(taskId, processInstanceId, message);
        return comment;
    }

    public List<Comment> getComments(String taskId) {
        List<Comment> comments = taskService.getTaskComments(taskId);
        return comments;
    }

}
