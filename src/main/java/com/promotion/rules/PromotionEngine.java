package com.promotion.rules;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ajay Kumar
 *	Promotion engine class which will apply rules and return final cart value
 * Ongoing Promotion
 *  3 of A's for 130
 *  2 of B's for 45
 *  C & D for 30
 */
public class PromotionEngine {
	/**
	 * Utility method to create and return a rule.
	 *
	 * @param fact
	 * @return RuleExecution
	 */
	@SuppressWarnings("rawtypes")
	public static RuleExecution createRuleExecution(Rule rule, Object... fact) {
		return new RuleExecution(rule, fact);
	}

	/**
	 * Validates and returns total Value.
	 *
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Integer run(RuleExecution ruleExecution) throws Exception{
		return Optional
				.ofNullable((Integer) ruleExecution.rule.validate(ruleExecution.fact == null ? null
						: Arrays.stream((Object[]) ruleExecution.fact).collect(Collectors.toList()).toArray(new Object[0])))
				.orElse(null);
	}

	/**
	 * Validates and returns corresponding total value.
	 *
	 * @param fact
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Integer run(Rule rule, Object fact) throws Exception{
		return run(createRuleExecution(rule, fact));
	}


}
