package com.wx.mapper;

import com.wx.model.pojo.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TaskMapper {

    @InsertProvider(type = TaskMapperProvider.class, method = "insertSql")
    @Options(useGeneratedKeys = true, keyColumn = "task_id", keyProperty = "taskId")
    public int insert(Task task);

    @Delete("delete from t_task where id = #{taskId}")
    public int delete(@Param("taskId") Integer taskId);

    @InsertProvider(type = TaskMapperProvider.class, method = "updateSql")
    public int update(Task task);

    @Select("select * from t_task where task_id = #{taskId}")
    public Task findById(@Param("taskId") Integer taskId);

    @Select("select * from t_task")
    public List<Task> find();
}
