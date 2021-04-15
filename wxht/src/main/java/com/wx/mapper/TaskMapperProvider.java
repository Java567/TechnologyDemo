package com.wx.mapper;

import com.wx.model.pojo.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class TaskMapperProvider {

    /**
     * 创建一个插入的SQL语句
     *
     * @param task
     * @return
     */
    public String insertSql(Task task) {
        return new SQL() {{
            INSERT_INTO("t_task");
            INTO_COLUMNS("title", "content", "expiration");
            INTO_VALUES("#{title}", "#{content}", "#{expiration}");
        }}.toString();
    }

    /**
     * 创建一个更新的SQL语句
     *
     * @param task
     * @return
     */
    public String updateSql(Task task) {
        return new SQL() {{
            UPDATE("t_task");
            if (StringUtils.isNoneBlank(task.getTitle())) {
                SET("title=#{title}");
            }
            if (StringUtils.isNoneBlank(task.getContent())) {
                SET("content=#{content}");
            }
            if (task.getExpiration() != null) {
                SET("expiration=#{expiration}");
            }
            WHERE("task_id=#{taskId}");

        }}.toString();
    }

}
