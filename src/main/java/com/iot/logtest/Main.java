package com.iot.logtest;

import com.iot.logtest.model.PluginInfo;
import com.iot.logtest.utils.PluginCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LHT
 */
public class Main {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IllegalAccessException {
        //生成100条插件数据
        List<PluginInfo> list = PluginCheck.getPluginInfo(10);
        logger.info("共生成数据" + list.size() + "条");
        logger.info(list.toString());
        logger.info(PluginCheck.checkIsInstallPlugin(list, new PluginInfo("插件8", "oui80", "厂商80", null)).toString());

    }
}
