package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.au.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
