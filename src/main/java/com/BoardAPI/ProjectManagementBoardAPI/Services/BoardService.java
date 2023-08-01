package com.BoardAPI.ProjectManagementBoardAPI.Services;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.BoardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.BoardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BoardService {
    @Autowired
    BoardRepo boardRepo;

    public  String createBoard(BoardRequest boardRequest) {
        BoardModel newBoard = new BoardModel();
        newBoard = BoardRequest.convertToEntity(newBoard, boardRequest);
        newBoard.setNewDate(new Date());
        newBoard.setIsActive(Boolean.TRUE);
        boardRepo.save(newBoard);
        return "Successfully Saved The information";
    }


    public BoardResponse getBoardInfo(Integer ifOfBoard) {
        return BoardResponse.convertToResponse(boardRepo.findById(ifOfBoard).get());
    }



}
