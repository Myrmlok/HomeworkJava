package com.example.teamandworkers.workers.WorkerServices.impl;

import com.example.teamandworkers.workers.Worker;
import com.example.teamandworkers.workers.WorkerRepository.WorkerRepository;
import com.example.teamandworkers.workers.WorkerRole.WorkerRoleEnum;
import com.example.teamandworkers.workers.WorkerServices.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository repository;
    @Override
    public Worker addWorker(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker getWorker(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Worker not found"));
    }

    @Override
    public Worker updateWorker(Worker worker) {
        var oldWorker=getWorker(worker.getId());
        if(worker.getName()!=null)oldWorker.setName(worker.getName());
        if(worker.getEmail()!=null)oldWorker.setEmail(worker.getEmail());
        if(worker.getPhone()!=null)oldWorker.setPhone(worker.getPhone());
        if(worker.getRole()!=null){
            if(worker.getRole().getRole()!= WorkerRoleEnum.BOSS){
                oldWorker.setRole(worker.getRole());
            }
        }
        return worker;
    }

    @Override
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }
}
