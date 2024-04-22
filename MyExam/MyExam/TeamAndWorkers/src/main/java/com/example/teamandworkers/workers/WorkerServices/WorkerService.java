package com.example.teamandworkers.workers.WorkerServices;

import com.example.teamandworkers.workers.Worker;

public interface WorkerService {
    Worker addWorker(Worker worker);
    Worker getWorker(Long id);
    Worker updateWorker(Worker worker);
    void deleteWorker(Long id);
}
