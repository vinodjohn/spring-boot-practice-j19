package com.sda.study.springbootpractice.handlers;

import com.sda.study.springbootpractice.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Custom handler to implement AuditorAware
 *
 * @author Vinod John
 * @Date 27.02.2023
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}
