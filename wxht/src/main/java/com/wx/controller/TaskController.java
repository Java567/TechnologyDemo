package com.wx.controller;

import com.github.pagehelper.PageInfo;
import com.wx.core.ResultInfo;
import com.wx.core.util.ResultInfoUtil;
import com.wx.model.dto.TaskDto;
import com.wx.model.pojo.Task;
import com.wx.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("tasks")
@Api(tags = "Task任务相关的API接口")
public class TaskController {


    @Resource
    private TaskService taskService;



    /**
     * 展示所有的任务列表
     */
    // @RequestMapping(path = "", method = RequestMethod.GET)
    @GetMapping(path = "", produces = "application/json;charset=utf-8" )
    @ApiOperation(value = "查询所有任务列表")
    public List<Task> findAll() {
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }

    /**
     * 创建一个Task
     * 其中@RequestBody是从Request的body获取参数，封装到对象中，而且@RequestBody作用于对象
     */
    @PostMapping("")
    @ApiOperation(value = "添加任务")
    public Integer addTask(@RequestBody TaskDto task) {
        Integer taskId = taskService.addTask(task);
        return taskId;
    }

    /**
     * 根据ID获取某个Task
     * tasks/id
     */
    @GetMapping("{id}")
    @ApiOperation(value = "获取某个任务", notes="获取某个任务")
    @ApiImplicitParam(name = "id", value = "0", required = true, dataType = "int", paramType = "path")
    public Task findById(@PathVariable Integer id) {
        Task task = taskService.findById(id);
        return task;
    }

    /**
     * 根据ID更新Task
     * 注解@RequestParam从Request获取参数，key=value格式的参数
     */
    @PutMapping("{id}")

    @ApiOperation(value="更新任务接口", notes = "根据路径的id更新Task记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "任务ID", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "title", value = "任务标题", required = true, dataType = "string"),
            @ApiImplicitParam(name = "expiration", value = "截止时间", required = true, dataType = "string"),
            @ApiImplicitParam(name = "content", value = "任务详情", required = true, dataType = "string"),
    })

    public ResultInfo<String> updateById(@PathVariable Integer id,
                                 @RequestParam String title,
                                 @RequestParam String content,
                                 @RequestParam String expiration) throws Exception {
        String result = taskService.update(id, title, content, expiration);
        return ResultInfoUtil.buildSuccess(result);
    }

    /**
     * 根据ID删除Task
     */
    @DeleteMapping("{id}")

    @ApiOperation(value="删除任务接口", notes = "根据路径的id删除Task记录")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, dataType = "int")

    public ResultInfo<String> delete(@PathVariable Integer id) {
        String result = taskService.delete(id);
        return ResultInfoUtil.buildSuccess(result);
    }


    @GetMapping(path = {"p", "p/{page}/{size}", "p/{page}"})
    @ApiOperation(value="分页查询任务接口", notes = "根据路径的页码和记录数分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页码", required = false),
            @ApiImplicitParam(name = "size", value = "分页条数", required = false),
    })
    public PageInfo<Task> selectForPage(@PathVariable(required = false) Integer page,
                                        @PathVariable(required = false)Integer size) {
        PageInfo<Task> taskPageInfo = taskService.selectForPage(page, size);
        return taskPageInfo;
    }
}
