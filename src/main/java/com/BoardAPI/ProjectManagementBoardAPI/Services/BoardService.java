package com.BoardAPI.ProjectManagementBoardAPI.Services;


import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardRepo boardRepo;
}
