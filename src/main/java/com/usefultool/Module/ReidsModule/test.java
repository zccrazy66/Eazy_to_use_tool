package com.usefultool.Module.ReidsModule;



public class test {

    public static void main(String[] args) {

        Product product = new Product();
        Alarm alarm = new Alarm();
        alarm.setTime(12);
        alarm.setType("test");
        product.setAlarm(alarm);

        System.out.println(product.getAlarm().getTime());
    }

}
