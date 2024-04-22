package com.example.teamandworkers.workers.WorkerRepository;

import com.example.teamandworkers.task.Task;
import com.example.teamandworkers.workers.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
