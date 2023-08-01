package com.BoardAPI.ProjectManagementBoardAPI.Repository;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardModel, Integer> {

}
