package com.example.querytesting.repositories;

import com.example.querytesting.entities.KeyTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<KeyTable, Integer> {
}
