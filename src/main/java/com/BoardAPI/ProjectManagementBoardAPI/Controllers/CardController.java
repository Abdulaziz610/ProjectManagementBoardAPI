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
@CrossOrigin("*")
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
    @GetMapping(value = "/api/boards/{board_id}/cards/{card_id}")
    public ResponseEntity<CardResponse> getCardFromBoardById(@PathVariable Integer board_id, @PathVariable Long card_id) throws ChangeSetPersister.NotFoundException {
        CardResponse cardResponse = cardService.getCardFromBoardById(board_id, card_id);
        return ResponseEntity.ok(cardResponse);
    }

    @PutMapping(value = "/api/boards/{board_id}/cards/{card_id}")
    public ResponseEntity<CardResponse> updateCardOnBoard(@PathVariable Integer board_id, @PathVariable Long card_id, @RequestBody CardRequest cardRequest) throws ChangeSetPersister.NotFoundException {
        CardResponse updatedCard = cardService.updateCardOnBoard(board_id, card_id, cardRequest);
        return ResponseEntity.ok(updatedCard);
    }
    @DeleteMapping(value = "/api/boards/{board_id}/cards/{card_id}")
    public ResponseEntity<String> deleteCardFromBoard(@PathVariable Integer board_id, @PathVariable Long card_id) throws ChangeSetPersister.NotFoundException {
        cardService.deleteCardFromBoard(board_id, card_id);
        String responseMessage = String.format("Card with ID %d has been deleted successfully from board %d.", card_id, board_id);
        return ResponseEntity.ok(responseMessage);
    }
}
