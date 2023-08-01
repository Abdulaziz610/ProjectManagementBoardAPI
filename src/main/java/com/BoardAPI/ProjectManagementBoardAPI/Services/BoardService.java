package com.BoardAPI.ProjectManagementBoardAPI.Services;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.BoardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.BoardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    BoardRepo boardRepo;

    public BoardResponse createBoard(BoardRequest boardRequest) {
        BoardModel newBoard = new BoardModel();
        newBoard.setTitle(boardRequest.getTitle());
       // newBoard.setCards(new ArrayList<>());
        newBoard.setNewDate(new Date());
        newBoard.setIsActive(true);
        boardRepo.save(newBoard);

        // Create the response object
        BoardResponse response = BoardResponse.builder()
                .board_id(newBoard.getId())
                .name(newBoard.getTitle())
                .columns(Map.of(1, "To do", 2, "In progress", 3, "Done"))
                .build();
        return response;
    }



























/*
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
*/


}
