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
     * @return
     */
    public static List<PluginInfo> getPluginInfo(int pluginCount) {
        List<PluginInfo> pluginInfoList = new ArrayList<>();
        for (int i = 0; i < pluginCount; i++) {
            String pluginName = "插件" + i;
            for (int j = i * pluginCount; j < pluginCount + i * pluginCount; j++) {
                pluginInfoList.add(new PluginInfo(pluginName, "oui" + j, null, "品牌" + j));
            }
        }
        return pluginInfoList;
    }

    /**
     * 判断该插件是否在黑名单那中
     *
     * @param existList  插件黑名单记录数据
     * @param pluginInfo 需要判断的插件对象
     * @return true false
     */
    public static Boolean checkIsInstallPlugin(List<PluginInfo> existList, PluginInfo pluginInfo) {
        //按插件分组
        Map<String, List<PluginInfo>> map = new HashMap<>();
        for (PluginInfo item : existList) {
            System.out.println(item.getPluginName().hashCode());
            map.put(item.getPluginName(), new ArrayList<>());
        }
        //按插件分组的顺序，为每个插件添加厂家信息
        for (PluginInfo item : existList) {
            map.get(item.getPluginName()).add(item);
        }
        //Java8实现
        //  Map<String, List<PluginInfo>> map = existList.stream().collect(Collectors.groupingBy(PluginInfo::getPluginName));

        //判断map中是否存在该记录，如果存在就判断该插件对应的厂商信息列表中是否包含该插件的厂商信息，若包含返回true,否则返回false
        return map.containsKey(pluginInfo.getPluginName()) ? (map.get(pluginInfo.getPluginName()).contains(pluginInfo) ? true : false) : false;
    }


}
