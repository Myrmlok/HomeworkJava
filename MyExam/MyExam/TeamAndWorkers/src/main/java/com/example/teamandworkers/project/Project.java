package com.example.teamandworkers.project;

import com.example.teamandworkers.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_project")
public class Project {
    @Id
    Long id;
    @Column(name = "name")
    String name;
    @OneToMany
    @JoinColumn(name = "projectId")
    List<Task> tasks;
}
