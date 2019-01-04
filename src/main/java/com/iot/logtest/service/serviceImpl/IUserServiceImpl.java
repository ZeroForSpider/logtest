package com.iot.logtest.service.serviceImpl;

import com.iot.logtest.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    private static Logger logger=LoggerFactory.getLogger(IUserServiceImpl.class);

    @Override
    public List<Integer> getList() {
        logger.info("调用Service的方法");
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        logger.info("调用Service的方法结束");
        return list;
    }
}
