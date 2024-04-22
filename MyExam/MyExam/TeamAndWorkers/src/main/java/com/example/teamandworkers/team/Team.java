package com.example.teamandworkers.team;

import com.example.teamandworkers.workers.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="_team")
public class Team {
    @Id
    Long id;
    @Column(name = "_name")
    String name;
    @OneToOne()
    @JoinColumn(name = "boss_id",referencedColumnName = "id")
    Worker boss;
    @OneToMany()
    @JoinColumn(name = "team_id")
    Set<Worker> workers;
}
