package com.course.business.eunms;

/**
 * @author jiange
 * @date 2020/6/30 15:42
 */
public class test {
    public static void main(String[] args) {
        PayTypeEnum payTypeEnum = PayTypeEnum.getByCode("ALI_PAY");
        PayTypeEnum name = PayTypeEnum.getByName("支付宝支付");
        System.out.println("name:"+name);
        System.out.println(payTypeEnum);
    }
}
