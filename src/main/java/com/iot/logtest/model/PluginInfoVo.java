package com.iot.logtest.model;

import java.util.List;

public class PluginInfoVo {
    /**
     * 插件名称
     */
    private String pluginName;

    /**
     * 插件对应的厂商信息列表
     */
    private List<PluginInfo> pluginInfoList;

    public PluginInfoVo() {
    }

    public PluginInfoVo(String pluginName, List<PluginInfo> pluginInfoList) {
        this.pluginName = pluginName;
        this.pluginInfoList = pluginInfoList;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public void setPluginInfoList(List<PluginInfo> pluginInfoList) {
        this.pluginInfoList = pluginInfoList;
    }

    public String getPluginName() {
        return pluginName;
    }

    public List<PluginInfo> getPluginInfoList() {
        return pluginInfoList;
    }
}
