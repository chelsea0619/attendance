package com.example.attendance_system.repository;

import com.example.attendance_system.entity.TestEntity;
import com.example.attendance_system.entity.TimelogEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TestRepository extends ListCrudRepository<TestEntity, Long> {
}
