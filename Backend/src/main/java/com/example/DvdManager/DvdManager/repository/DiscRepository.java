package com.example.DvdManager.DvdManager.repository;

import com.example.DvdManager.DvdManager.model.Disc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscRepository extends JpaRepository<Disc, Long> {
}
