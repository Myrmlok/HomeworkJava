package com.example.teamandworkers.task;

import com.example.teamandworkers.task.TaskBlock.TaskBlockABout.BlockFile;
import com.example.teamandworkers.task.TaskBlock.TaskBlockABout.BlockText;
import com.example.teamandworkers.task.TaskBlock.TaskBlockAnswer.TaskBlockAnswer;
import com.example.teamandworkers.task.TaskStatus.TaskStatus;
import com.example.teamandworkers.workers.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_task")
public class Task {
    @Id
    Long id;
    @Column(name = "_name")
    String name;
    @Column(name = "beginTime")
    LocalDateTime TimeStart;
    @Column(name = "endTime")
    LocalDateTime TimeEnd;
    @ManyToOne
    @JoinColumn(name = "boss_id",referencedColumnName = "id")
    Worker boss;
    @ManyToOne
    @JoinColumn(name = "worker_id",referencedColumnName = "id")
    Worker worker;
    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    TaskStatus status;
    @OneToMany
    @JoinColumn(name="task_id")
    List<BlockText> blockTexts;
    @OneToMany
    @JoinColumn(name = "task_id")
    List<BlockFile> blockFiles;
    @OneToMany
    @JoinColumn(name = "task_id")
    List<TaskBlockAnswer> blockAnswers;


}
