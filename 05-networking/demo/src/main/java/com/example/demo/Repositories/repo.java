package com.example.demo.Repositories;

import com.example.demo.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Message, Long> {
}