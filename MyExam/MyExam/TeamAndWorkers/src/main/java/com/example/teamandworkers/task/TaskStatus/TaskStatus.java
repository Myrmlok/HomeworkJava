package com.example.teamandworkers.task.TaskStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task_status")
public class TaskStatus {
    @Id
    Long id;
    @Column(name = "_name")
    @Enumerated(EnumType.STRING)
    TaskStatusEnum name;
}
