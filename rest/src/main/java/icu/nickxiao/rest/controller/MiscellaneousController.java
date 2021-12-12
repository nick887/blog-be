package icu.nickxiao.rest.controller;

import icu.nickxiao.model.dao.TimeRecordMapper;
import icu.nickxiao.model.entity.TimeRecord;
import icu.nickxiao.rest.vo.blog.TimeRecordVO;
import java.sql.Timestamp;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@RestController
@RequestMapping("/mis")
@RequiredArgsConstructor
public class MiscellaneousController {
    private final TimeRecordMapper timeRecordMapper;

    @GetMapping("/timeRecord")
    public TimeRecordVO getTimeRecord() {
        TimeRecord timeRecord = timeRecordMapper.selectByPrimaryKey(1L).get();
        return TimeRecordVO.builder()
                .createTime(Timestamp.valueOf(timeRecord.getTimestamp()))
                .build();
    }
}
