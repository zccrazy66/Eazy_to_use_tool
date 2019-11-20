package com.usefultool.Module.ReidsModule;


import com.usefultool.Module.ReidsModule.RealTime.RealTime;
import com.usefultool.Module.ReidsModule.Status.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Attribute attribute;
    private Alarm alarm;
    private RealTime realTime;
    private Status status;

}
