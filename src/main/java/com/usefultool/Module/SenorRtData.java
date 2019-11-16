package com.usefultool.Module;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SenorRtData {
    // 传感器地址
    private int senorId;
    // 采样GMT,采样开始时间:秒
    private int gmt;
    // 波形控制位
    private int waveCtr;
    // 采样通道【0x0001|X轴加速度,0x0002|X速度,0x0004|Y轴加速度,0x0008|Y轴速度,0x0010|Z轴加速度,0x0020|Z轴速度,0x0080|温度】
    private int channel;
    // 系数，浮点数字,
    private double coefficient;
    // 采样频率
    private int frequency;
    // 采样点数
    private int sampleNum;
    // 有效值
    private double effectiveValue;
    // 峰值
    private double peek;
    // 峰枫值
    private double peekToPeek;
    // 温度
    private double temperature;
    // 采样点数据
    private List<Integer> dataList;
}
