package com.devsession.conferencedemoapi.repositories;

import com.devsession.conferencedemoapi.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
