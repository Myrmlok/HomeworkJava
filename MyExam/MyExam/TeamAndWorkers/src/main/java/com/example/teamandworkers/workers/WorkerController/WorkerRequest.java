package com.example.teamandworkers.workers.WorkerController;

import com.example.teamandworkers.workers.WorkerRole.WorkerRole;
import com.example.teamandworkers.workers.WorkerRole.WorkerRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class WorkerRequest {
    String name;
    Long id;
    private String email;
    private String phone;
    WorkerRoleEnum role;
    Long teamId;
}
