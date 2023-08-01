package com.BoardAPI.ProjectManagementBoardAPI.Controllers;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.BoardRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "board" )
public class BoardController {
    List<BoardModel> boards = new ArrayList<>();


    @PostMapping(value = "/api/boards")
    public String createBoard(@RequestBody BoardRequest boardRequest) {
        return "Successfully Saved The Recipe";
    }











}
