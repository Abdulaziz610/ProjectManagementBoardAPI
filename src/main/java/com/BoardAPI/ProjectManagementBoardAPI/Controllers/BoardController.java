package com.BoardAPI.ProjectManagementBoardAPI.Controllers;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.BoardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.BoardResponse;
import com.BoardAPI.ProjectManagementBoardAPI.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/boards")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepo boardRepo;



    @PostMapping
    public String createBoard(@RequestBody BoardRequest boardRequest) {
        boardService.createBoard(boardRequest);
        return "Successfully Saved The information";
    }


    @GetMapping
    public BoardResponse getBoardInfo(@RequestParam Integer idOfBoard) {
        return boardService.getBoardInfo(idOfBoard);
    }

}
