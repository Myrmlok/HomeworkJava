package com.example.teamandworkers.workers.WorkerController;

import com.example.teamandworkers.team.Team;
import com.example.teamandworkers.workers.WorkerRole.WorkerRole;
import com.example.teamandworkers.workers.WorkerRole.WorkerRoleEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerResponse {

    private Long id;
    String name;
    private String email;
    private String phone;
    WorkerRoleEnum role;
    String team;
}
