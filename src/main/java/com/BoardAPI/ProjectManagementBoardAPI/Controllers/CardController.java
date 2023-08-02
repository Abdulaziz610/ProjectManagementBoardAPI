package com.BoardAPI.ProjectManagementBoardAPI.Controllers;


import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.CardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.CardResponse;
import com.BoardAPI.ProjectManagementBoardAPI.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "board")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping(value = "/api/boards/{board_id}/cards")
    public ResponseEntity<CardResponse> addCardToBoard(@PathVariable Integer board_id, @RequestBody CardRequest cardRequest) throws ChangeSetPersister.NotFoundException {
        CardResponse createdCard = cardService.addCardToBoard(board_id, cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
    }

    @GetMapping(value = "/api/boards/{board_id}/cards")
    public ResponseEntity<List<CardResponse>> getAllCardsFromBoard(@PathVariable Integer board_id) throws ChangeSetPersister.NotFoundException {
        List<CardResponse> cardResponses = cardService.getAllCardsFromBoard(board_id);
        return ResponseEntity.ok(cardResponses);
   }
}
