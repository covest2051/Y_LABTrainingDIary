package com.trainingdiary.domain;

import java.time.LocalDateTime;

public class AuditRecord {
    private LocalDateTime timestamp;
    private String actionType;
    private String username;

    public AuditRecord(LocalDateTime timestamp, String actionType, String username) {
        this.timestamp = timestamp;
        this.actionType = actionType;
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getActionType() {
        return actionType;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "AuditRecord{" +
                "timestamp=" + timestamp +
                ", actionType='" + actionType + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
