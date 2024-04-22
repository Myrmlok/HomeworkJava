package com.example.teamandworkers.task.TaskBlock.TaskBlockAnswer.TaskTypeBlockAnswer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "type_answer")
public class TaskTypeBlockAnswer {
    @Id
    Long id;
    @Column(name = "_name")
    @Enumerated(EnumType.STRING)
    TaskTypeBlockAnswerEnum typeBlockAnswer;
}
