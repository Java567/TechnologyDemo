package com.wx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wx.core.exception.ParameterException;
import com.wx.core.util.AssertUtil;
import com.wx.mapper.TaskMapper;
import com.wx.model.dto.TaskDto;
import com.wx.model.pojo.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;

    /**
     * 获取所有的任务数据
     * @return
     */
    public List<Task> getTasks() {
        List<Task> taskList = taskMapper.find();
        return taskList;
    }

    public Integer addTask(TaskDto taskDto) {
        // 参数校验
        String title = taskDto.getTitle();
        AssertUtil.isNotEmpty(title, "请输入任务标题。");
        String content = taskDto.getContent();
        AssertUtil.isNotEmpty(content, "请输入任务内容。");
        Date expiration = taskDto.getExpiration();
        AssertUtil.isNotNull(expiration);

        Task task = new Task();
        // 对象的拷贝 common beans方法
        BeanUtils.copyProperties(taskDto, task);

        taskMapper.insert(task);
        return task.getTaskId();
    }

    public Task findById(Integer id) {
        AssertUtil.isTrue(id == null || id < 1, "请选择一条记录进行操作");
        Task task = taskMapper.findById(id);
        return task;
    }

    public String update(Integer id, String title,
                         String content, String expiration)
            throws Exception {

        // 先根据ID获取记录
        Task task = taskMapper.findById(id);
        if (task == null) {
            throw new ParameterException("该记录不存在，请重试");
        }
        task.setContent(content);
        // 字符串转日期时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        task.setExpiration(simpleDateFormat.parse(expiration));
        task.setTaskId(id);
        task.setTitle(title);
        // 更新数据库
         taskMapper.update(task);
        return "successful.";
    }


    public String delete(Integer id) {
        int count = taskMapper.delete(id);
        if (count == 0) {
            return "failure.";
        }
        return "successful.";
    }


    public PageInfo<Task> selectForPage(Integer page, Integer size) {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        PageHelper.startPage(page, size);

        List<Task> tasks = taskMapper.find();

        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);
        return taskPageInfo;
    }

}
