package com.example.teamandworkers.workers.WorkerRepository;

import com.example.teamandworkers.workers.WorkerRole.WorkerRole;
import com.example.teamandworkers.workers.WorkerRole.WorkerRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRoleRepository extends JpaRepository<WorkerRole,Long> {
    WorkerRole findByRole(WorkerRoleEnum roleEnum);
}
