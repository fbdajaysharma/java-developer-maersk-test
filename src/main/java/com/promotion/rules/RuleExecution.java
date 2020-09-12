package com.promotion.rules;

public class RuleExecution {

    Rule rule;
    Object fact;
    RuleExecution(Rule r, Object... f){
        super();
        this.rule = r;
        this.fact = f;
    }
}
