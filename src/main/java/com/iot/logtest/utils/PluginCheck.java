package com.iot.logtest.utils;

import com.iot.logtest.model.PluginInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LHT
 * 插件配置检测
 */
public class PluginCheck {


    /**
     * 生成插件数据 模拟数据库中存放的插件数据
     * 插件名称	OUI	厂商	型号
     * 插件名1	OU1	 厂1	型1
     * 插件名1	OU2	 厂2	型2
     * 插件名2	OU3	 厂3	型3
     * 插件名2	OU4	 厂4	型4
     *
     * @param pluginCount 生成多少个插件信息，每个插件有多个厂商信息
     * @return 以插件名为键, 插件对应的厂商信息列表为值的map
     */
    public static Map<String, List<PluginInfo>> getPluginInfo(int pluginCount) {
        List<PluginInfo> pluginInfoList = new ArrayList<>();
        for (int i = 0; i < pluginCount; i++) {
            String pluginName = "插件" + i;
            for (int j = i * pluginCount; j < pluginCount + i * pluginCount; j++) {
                pluginInfoList.add(new PluginInfo(pluginName, "oui" + j, "厂商" + j, "品牌" + j));
            }
        }
        Map<String, List<PluginInfo>> map = new HashMap<>();
        for (PluginInfo item : pluginInfoList) {
            if (!map.containsKey(item.getPluginName())) {
                map.put(item.getPluginName(), new ArrayList<>());
            }
            map.get(item.getPluginName()).add(item);
        }
        return map;
    }

    /**
     * 判断该插件是否在黑名单那中
     *
     * @param map        以插件名为键,插件对应的厂商信息列表为值的map
     * @param pluginInfo 需要判断的插件对象
     * @return true false
     */
    public static Boolean checkIsInstallPlugin(Map<String, List<PluginInfo>> map, PluginInfo pluginInfo) {
        //判断map中是否存在该记录，如果存在就判断该插件对应的厂商信息列表中是否包含该插件的厂商信息，若包含返回true,否则返回false
        return map.containsKey(pluginInfo.getPluginName()) && (map.get(pluginInfo.getPluginName()).contains(pluginInfo));
    }


}
