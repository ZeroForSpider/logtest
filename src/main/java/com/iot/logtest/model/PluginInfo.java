package com.iot.logtest.model;

import com.sun.org.apache.regexp.internal.RE;
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
    private String pluginName = "";

    /**
     * Oui名称
     */
    private String ouiName = "";

    /**
     * 厂商名称
     */
    private String factoryName = "";


    /**
     * 型号
     */
    private String brand = "";

    public PluginInfo() {
        this.pluginName = "";
        this.ouiName = "";
        this.factoryName = "";
        this.brand = "";
    }

    @Override
    public String toString() {
        return "PluginInfo{" +
                "pluginName='" + pluginName + '\'' +
                ", ouiName='" + ouiName + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public PluginInfo(String pluginName, String ouiName, String factoryName, String brand) {
        this.pluginName = pluginName == null ? "" : pluginName;
        this.ouiName = ouiName == null ? "" : ouiName;
        this.factoryName = factoryName == null ? "" : factoryName;
        this.brand = brand;
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

    public String getBrand() {
        return brand;
    }

    /**
     * 写入日志
     *
     * @param field
     */
    public void writeLog(String field) {
        if (logger.isInfoEnabled()) {
            logger.info("当前" + this.pluginName + "的" + field + "不等于待查询插件" + this.pluginName + "的" + field + ",返回结果为false");
        }
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
        if (obj instanceof PluginInfo) {
            PluginInfo pluginInfo = (PluginInfo) obj;
            String field;
            if (this.ouiName.equals(pluginInfo.ouiName)) {
                if (this.factoryName.equals(pluginInfo.factoryName)) {
                    if (this.brand.equals(pluginInfo.brand)) {
                        return true;
                    } else {
                        field = "brand";
                    }
                } else {
                    field = "factoryName";
                }
            } else {
                field = "ouiName";
            }
            writeLog(field);
        }
        return false;
    }
}
