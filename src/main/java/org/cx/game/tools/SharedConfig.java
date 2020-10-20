package org.cx.game.tools;

import org.cx.game.command.CommandInvokerFactory;
import org.cx.game.command.IInvoker;
import org.cx.game.command.check.CheckHelper;
import org.cx.game.command.check.CheckHelperBuilder;
import org.cx.game.rule.RuleBuilder;
import org.cx.game.rule.RuleHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configure.properties")
@ComponentScan(basePackages = {"org.cx.game.tools", "org.cx.game.rule", "org.cx.game.observer", "org.cx.game.tag", "org.cx.game.command.check"})
public class SharedConfig {
	
	/*@Bean("tagHelper")
	public TagHelper getTagHelper(TagHelperBuilder builder) {
		return builder.getInstance();
	}*/
	
	@Bean("checkHelper")
	public CheckHelper getCheckHelper(CheckHelperBuilder builder) {
		return builder.getInstance();
	}
	
	@Bean("ruleHelper")
	public RuleHelper getRuleHelper(RuleBuilder builder) {
		return builder.getInstance();
	}
	
	@Bean
	public CommandInvokerFactory getCommandInvokeFactory() {
		return new CommandInvokerFactory();
	}
	
	/*@Bean("jackson")
	public Jackson getJackson() {
		return new Jackson();
	}*/
}
