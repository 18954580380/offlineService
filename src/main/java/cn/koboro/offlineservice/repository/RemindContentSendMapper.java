package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.pojo.entity.RemindContentSend;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RemindContentSendMapper extends Mapper<RemindContentSend> {

    void save(RemindContentSend rSend);

    List<Map> selectRemindContentSend();

}
