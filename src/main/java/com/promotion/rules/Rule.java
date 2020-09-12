package com.promotion.rules;

@FunctionalInterface
public interface Rule <R, F, E extends Exception>{

    /*
    *   Evaluate the rule based on facts
     */
    R validate(F... fact) throws E;
}
