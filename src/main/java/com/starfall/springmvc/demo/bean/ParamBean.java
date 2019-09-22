package com.starfall.springmvc.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo1.bean
 * @className ParamBean
 * @date 2019/8/24 22:32
 * @description ParamBean
 */
public class ParamBean {
    private String param1;
    private Integer param2;
    private Boolean param3;
    private BigDecimal param4;
    private Date param5;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

    public Boolean getParam3() {
        return param3;
    }

    public void setParam3(Boolean param3) {
        this.param3 = param3;
    }

    public BigDecimal getParam4() {
        return param4;
    }

    public void setParam4(BigDecimal param4) {
        this.param4 = param4;
    }

    public Date getParam5() {
        return param5;
    }

    public void setParam5(Date param5) {
        this.param5 = param5;
    }

    @Override
    public String toString() {
        return "ParamBean{" +
                "param1='" + param1 + '\'' +
                ", param2=" + param2 +
                ", param3=" + param3 +
                ", param4=" + param4 +
                ", param5=" + param5 +
                '}';
    }
}
