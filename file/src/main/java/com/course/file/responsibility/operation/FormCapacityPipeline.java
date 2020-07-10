package com.course.file.responsibility.operation;

import com.course.file.responsibility.impl.IResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiange
 * @date 2020/7/10 15:57
 */
public class FormCapacityPipeline {
    public static FormCapacityPipeline createInstance(){
        return new FormCapacityPipeline();
    }
    private final List<IResponsibility> capacities = new ArrayList<>();

    public FormCapacityPipeline add(IResponsibility iResponsibility){
        capacities.add(iResponsibility);
        return this;
    }

    public String excution(String parmas){
        for (IResponsibility responsibility : capacities){
            parmas  = responsibility.doSome(parmas);
        }
        return parmas;
    }
}
