package com.example.teamandworkers.task.TaskBlock.TaskBlockAnswer;

import com.example.teamandworkers.task.TaskBlock.TaskBlockAnswer.TaskTypeBlockAnswer.TaskTypeBlockAnswer;
import com.example.teamandworkers.task.TaskBlock.TaskBlockAnswer.TaskTypeBlockAnswer.TaskTypeBlockAnswerEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "block_answer")
public class TaskBlockAnswer {
    @Id
    Long id;
    @Column(name ="count" )
    int count;
    @Column(name = "limitations")
    String limitations;
    @Column(name = "about")
    String about;
    @ManyToOne
    @JoinColumn(name = "type_id",referencedColumnName = "id")
    TaskTypeBlockAnswer typeBlockAnswer;

}
