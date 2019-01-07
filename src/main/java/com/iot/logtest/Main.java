package com.iot.logtest;

import com.iot.logtest.model.PluginInfo;
import com.iot.logtest.utils.PluginCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.BiConsumer;

/**
 * @author LHT
 */
public class Main {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IllegalAccessException {
        //  生成10条插件数据
        Map<String, List<PluginInfo>> map = PluginCheck.getPluginInfo(10);
        PluginInfo pluginInfo = new PluginInfo("插件8", "oui80", "厂商80", "品牌80");
        logger.info("共生成数据" + map.size() + "条");
        logger.info("插件数据如下：\n" + map.toString());
        logger.info("待查询插件如下：\n" + pluginInfo);
        logger.info("查询结果为" + PluginCheck.checkIsInstallPlugin(map, pluginInfo).toString());

    }
}
