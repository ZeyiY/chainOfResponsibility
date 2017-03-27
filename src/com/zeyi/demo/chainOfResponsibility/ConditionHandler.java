package com.zeyi.demo.chainOfResponsibility;

/**
 * Created by yangsen1 on 2017/3/26.
 */
public interface ConditionHandler {
    boolean checkCondition(ConditionRequest conditionRequest);
}
