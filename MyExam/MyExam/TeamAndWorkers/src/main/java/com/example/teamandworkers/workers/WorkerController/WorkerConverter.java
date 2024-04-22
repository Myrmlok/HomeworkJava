package com.example.teamandworkers.workers.WorkerController;

import com.example.teamandworkers.team.repository.TeamRepository;
import com.example.teamandworkers.workers.Worker;
import com.example.teamandworkers.workers.WorkerRepository.WorkerRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerConverter {
    private final WorkerRoleRepository repository;
    private final TeamRepository teamRepository;
    public Worker convertToWorker(WorkerRequest request){
        return Worker.builder()
                .email(request.getEmail())
                .phone(request.getPhone())
                .name(request.getName())
                .id(request.id)
                .role(repository.findByRole(request.role))
                .team(teamRepository.findById(request.teamId).orElse(null))
                .build();
    }
    public WorkerResponse convertToResponse(Worker worker){
        return WorkerResponse.builder()
                .id(worker.getId())
                .email(worker.getEmail())
                .phone(worker.getPhone())
                .role(worker.getRole().getRole())
                .name(worker.getName())
                .team(worker.getTeam().getName())
                .build();
    }
}
