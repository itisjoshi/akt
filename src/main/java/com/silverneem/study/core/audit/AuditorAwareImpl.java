/**
 * 
 */
package com.silverneem.study.core.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.silverneem.study.web.security.StudyUserDetails;

/**
 * @author pmjoshi
 *
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
			return "SYSTEM";
		} else {
			return ((StudyUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();			
		}
	}
}
