package com.github.kuangcp.reply.activiti.execption;

import lombok.extern.slf4j.Slf4j;

/**
 * 候选人为空异常.
 *
 * @author: huang
 * Date: 17-11-6
 */
@Slf4j
public class CandidateUserEmptyException extends RuntimeException {

    public CandidateUserEmptyException() {
    }

    public CandidateUserEmptyException(String message) {
        super(message);
        log.error(this.getClass().getSimpleName() + " : " + message);
    }

    public CandidateUserEmptyException(String message, Throwable cause) {
        super(message, cause);
        log.error(this.getClass().getSimpleName() + " : " + message, cause.getMessage());
    }

    public CandidateUserEmptyException(Throwable cause) {
        super(cause);
        log.error(cause.getMessage());
    }

    public CandidateUserEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(this.getClass().getSimpleName() + " : " + message, cause.getMessage());
    }
}
