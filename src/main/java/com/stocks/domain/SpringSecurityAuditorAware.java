package com.stocks.domain;

import org.springframework.data.domain.AuditorAware;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
	@Override
	public String getCurrentAuditor() {
		return "auditUser";
	}
}
