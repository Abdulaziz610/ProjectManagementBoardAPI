package com.BoardAPI.ProjectManagementBoardAPI.Repository;


import com.BoardAPI.ProjectManagementBoardAPI.Models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<CardModel, Integer> {
}
