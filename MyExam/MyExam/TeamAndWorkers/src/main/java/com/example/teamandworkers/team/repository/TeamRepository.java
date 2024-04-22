package com.example.teamandworkers.team.repository;

import com.example.teamandworkers.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
