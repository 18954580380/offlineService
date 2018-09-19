package cn.koboro.offlineservice.service.impl;

import cn.koboro.offlineservice.annotation.AutoPage;
import cn.koboro.offlineservice.pojo.entity.ReservationTime;
import cn.koboro.offlineservice.repository.ReservationTimeMapper;
import cn.koboro.offlineservice.service.ReservationTimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ReservationTimeServiceImpl implements ReservationTimeService {
	@Resource
    private ReservationTimeMapper reservationTimeMapper;
    /**
     * 根据任务id查询时间段
     */
	@Override
	@AutoPage
	public List<ReservationTime> findReservationTimeByTaskId(Integer taskId) {
		return reservationTimeMapper.findReservationTimeByTaskId(taskId);
	}

}
