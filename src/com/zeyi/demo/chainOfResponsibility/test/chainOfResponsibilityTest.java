package com.zeyi.demo.chainOfResponsibility.test;

import com.zeyi.demo.chainOfResponsibility.ConditionRequest;
import com.zeyi.demo.chainOfResponsibility.FirstConditionCheck;
import com.zeyi.demo.chainOfResponsibility.SecondConditionCheck;

/**
 * Created by yangsen1 on 2017/3/26.
 */
public class chainOfResponsibilityTest {
    public static void main(String args[]){
        FirstConditionCheck     firstConditionCheck     =   new     FirstConditionCheck();
        SecondConditionCheck    secondConditionCheck    =   new     SecondConditionCheck();
        ConditionRequest        conditionRequest        =   new     ConditionRequest();
        boolean                 check;

        //配置链顺序
        firstConditionCheck.setConditionHandler(secondConditionCheck);
        check =   firstConditionCheck.checkCondition(conditionRequest);

        System.out.println("最后的链结果："+check);
    }
}
