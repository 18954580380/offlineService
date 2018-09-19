package cn.koboro.offlineservice.service;

import cn.koboro.offlineservice.pojo.entity.ReservationTime;

import java.util.List;

public interface ReservationTimeService {
     List<ReservationTime> findReservationTimeByTaskId(Integer taskId);
}
