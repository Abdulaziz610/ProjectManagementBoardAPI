package com.BoardAPI.ProjectManagementBoardAPI.Controllers;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.BoardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.AllBoardsResponse;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.BoardResponse;
import com.BoardAPI.ProjectManagementBoardAPI.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepo boardRepo;

    @PostMapping(value = "/api/boards")
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardRequest boardRequest) {
        BoardResponse createdBoard = boardService.createBoard(boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoard);
    }

    @GetMapping(value = "/api/boards")
    public ResponseEntity<AllBoardsResponse> getAllBoards() {
        List<BoardResponse> boards = boardService.getAllBoards();
        AllBoardsResponse getAllBoards = new AllBoardsResponse(boards);
        return ResponseEntity.status(HttpStatus.CREATED).body(getAllBoards);
    }


    @PutMapping("/api/boards/{boardId}") // Endpoint for updating a board by ID
    public ResponseEntity<BoardResponse> updateBoard(@PathVariable Integer boardId, @RequestBody BoardRequest boardRequest) throws ChangeSetPersister.NotFoundException {
        BoardResponse updatedBoard = boardService.updateBoard(boardId, boardRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBoard);
    }

    @DeleteMapping("/api/boards/{boardId}") // Endpoint for deleting a board by ID
    public ResponseEntity<Map<String, String>> deleteBoard(@PathVariable Integer boardId) {
        boolean isDeleted = boardService.deleteBoard(boardId);
        if (isDeleted) {
            Map<String, String> response = new HashMap<>();
            response.put("successful", "true");
            response.put("message", "Board with ID " + boardId + " has been deleted successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("successful", "false");
            response.put("message", "Board with ID " + boardId + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}




















   /* @PostMapping(value = "/api/boards")
    public String createBoard(@RequestBody BoardRequest boardRequest) {
        boardService.createBoard(boardRequest);
        return "Successfully Saved The information";
    }


    @GetMapping(value = "/api/boards/{id}")
    public BoardResponse getBoardInfo(@RequestParam Integer idOfBoard) {
        return boardService.getBoardInfo(idOfBoard);
    }
*/

