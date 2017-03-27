package com.zeyi.demo.chainOfResponsibility;

/**
 * Created by yangsen1 on 2017/3/26.
 */
public abstract class AbstractConditionHandler {
    private ConditionHandler conditionHandler;

    public ConditionHandler getConditionHandler() {
        return conditionHandler;
    }

    public void setConditionHandler(ConditionHandler conditionHandler) {
        this.conditionHandler = conditionHandler;
    }
}
