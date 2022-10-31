package com.syedomee.springtodo.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

//nothing but checking the git status

@Entity
@Table(name = "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Please, insert the description")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

    @Getter
    @Setter
    private String priority;

    public TodoItem() {

    }

    public TodoItem(String description, String priority) {
        this.description = description;
        this.complete = false;
        this.priority = priority;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', complete='%s', priority='%s', createdDate='%s', modifiedDate='%s'}",
        id, description, complete, priority, createdDate, modifiedDate);
    }
}
