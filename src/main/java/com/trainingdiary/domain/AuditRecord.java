package com.trainingdiary.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Represents an audit record.
 * An audit record is a log of a significant event or change in the system.
 */
@Getter
public class AuditRecord {
    private LocalDateTime timestamp;
    private String actionType;
    private String username;

    /**
     * Constructor for the AuditRecord class.
     *
     * @param timestamp The time when the event occurred.
     * @param actionType The type of action that was performed.
     * @param username The username of the user who performed the action.
     */
    public AuditRecord(LocalDateTime timestamp, String actionType, String username) {
        this.timestamp = timestamp;
        this.actionType = actionType;
        this.username = username;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter) + ": " + actionType;
    }
}
