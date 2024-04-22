package com.example.teamandworkers.workers;

import com.example.teamandworkers.task.Task;
import com.example.teamandworkers.workers.WorkerRole.WorkerRole;
import com.example.teamandworkers.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "_name")
    String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    WorkerRole role;
    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    Team team;
    @OneToMany
    @JoinColumn(name = "worker_id")
    List<Task> tasks;
    @OneToMany
    @JoinColumn(name = "boss_id")
    List<Task>  MyTasks;
}
