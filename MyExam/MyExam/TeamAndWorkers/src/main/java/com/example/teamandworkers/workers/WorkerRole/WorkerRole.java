package com.example.teamandworkers.workers.WorkerRole;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_role")
public class WorkerRole {
    @Id
    Long id;
    @Column(name = "_name")
    @Enumerated(EnumType.STRING)
    WorkerRoleEnum role;
}
