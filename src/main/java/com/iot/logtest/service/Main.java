package com.iot.logtest.service;

import com.iot.logtest.model.PluginInfo;
import com.iot.logtest.model.PluginInfoVo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

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

    public static Boolean checkIsInstallPlugin(List<PluginInfo> existList, PluginInfo pluginInfo) {
//        Map<String, List<PluginInfo>> map = new HashMap<>();
//        for (PluginInfo item : existList) {
//            map.put(item.getPluginName(), new ArrayList<>());
//        }
//        for (PluginInfo item : existList) {
//            map.get(item.getPluginName()).add(item);
//        }

        //Java8实现
        Map<String,List<PluginInfo>> map=existList.stream().collect(Collectors.groupingBy(PluginInfo::getPluginName));
        return map.containsKey(pluginInfo.getPluginName()) ? (map.get(pluginInfo.getPluginName()).contains(pluginInfo) ? true : false) : false;
    }

    public static void main(String[] args) throws IllegalAccessException {
        List<PluginInfo> list = getPluginInfo(10000);
        System.out.println("共生成数据"+list.size());
        list.forEach(m-> System.out.println(m));
        System.out.println(checkIsInstallPlugin(list, new PluginInfo("插件8", "oui861", null, "品牌8611")));

        }
    }
