package com.course.business.eunms;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author jiange
 * @date 2020/6/30 15:38
 */
public enum PayTypeEnum {
    ALI_PAY("支付宝支付"),
    WEIXIN_PAY("微信支付");

    private PayTypeEnum(String desc){
        this.desc = desc;
    };
    private String desc;

    public String getCode() {
        return this.name();
    }
    public String getName() {
        return this.desc;
    }

    public static PayTypeEnum getByCode(String code) {
        return (PayTypeEnum) Arrays.stream(values()).filter((value) -> {
            return value.name().equals(code);
        }).findFirst().orElse((PayTypeEnum) null);
    }


    public static PayTypeEnum getByName(String name) {
        return (PayTypeEnum)Arrays.stream(values()).filter((value) -> {
            return Objects.equals(value.desc, name);
        }).findFirst().orElse((PayTypeEnum) null);
    }

}
