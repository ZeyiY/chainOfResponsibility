package com.zeyi.demo.chainOfResponsibility;

/**
 * Created by yangsen1 on 2017/3/26.
 */
public class SecondConditionCheck extends AbstractConditionHandler implements ConditionHandler {
    @Override
    public boolean checkCondition(ConditionRequest conditionRequest) {

        System.out.println("执行了此节点：SecondConditionCheck");

        //  写这个条件的操作，相当于if 譬如如下
        if (conditionRequest == null ){
            if (conditionRequest.getName().equals("error")){
                return false;
            }
        }

        // 此条件通过 责任链向下传递
        if (getConditionHandler() !=null){
            return getConditionHandler().checkCondition(conditionRequest);
        }
        return true;
    }
}
