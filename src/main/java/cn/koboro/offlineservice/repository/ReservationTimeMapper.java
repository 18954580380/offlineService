package cn.koboro.offlineservice.repository;

import cn.koboro.offlineservice.core.IBaseMapper;
import cn.koboro.offlineservice.pojo.entity.ReservationTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationTimeMapper extends IBaseMapper<ReservationTime> {
    List<ReservationTime> findReservationTimeByTaskId(@Param("taskId") Integer taskId);

    void deleteByTaskId(@Param("taskId") Integer taskId);
}
