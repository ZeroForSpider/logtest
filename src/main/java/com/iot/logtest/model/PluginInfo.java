package com.iot.logtest.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插件信息
 *
 * @author LHT
 */
public class PluginInfo {

    private final static Logger logger = LoggerFactory.getLogger(PluginInfo.class);

    /**
     * 插件名称
     */
    private String pluginName;

    /**
     * Oui名称
     */
    private String ouiName;

    /**
     * 厂商名称
     */
    private String factoryName;


    /**
     * 型号
     */
    private String model;

    public PluginInfo() {
    }

    @Override
    public String toString() {
        return "PluginInfo{" +
                "pluginName='" + pluginName + '\'' +
                ", ouiName='" + ouiName + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public PluginInfo(String pluginName, String ouiName, String factoryName, String model) {
        this.pluginName = pluginName;
        this.ouiName = ouiName;
        this.factoryName = factoryName;
        this.model = model;
    }

    public String getPluginName() {
        return pluginName;
    }

    public String getOuiName() {
        return ouiName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getModel() {
        return model;
    }

    /**
     * 重写hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return (ouiName + factoryName + model).hashCode();
    }

    /**
     * 重写equals方法判断插件信息是否相等
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof PluginInfo)) {
            return false;
        }
        PluginInfo pluginInfo = (PluginInfo) obj;
        boolean oui = ouiName == null || ouiName.equals(pluginInfo.ouiName);
        boolean factory = factoryName == null || factoryName.equals(pluginInfo.factoryName);
        boolean modelOk = model == null || model.equals(pluginInfo.model);
        return oui && factory && modelOk;
    }

}