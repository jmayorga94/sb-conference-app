package com.devsession.conferencedemoapi.repositories;

import com.devsession.conferencedemoapi.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}