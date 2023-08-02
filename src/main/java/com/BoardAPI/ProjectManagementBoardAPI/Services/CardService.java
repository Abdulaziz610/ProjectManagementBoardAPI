package com.BoardAPI.ProjectManagementBoardAPI.Services;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Models.CardModel;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.BoardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.Repository.CardRepo;
import com.BoardAPI.ProjectManagementBoardAPI.RequestObjects.CardRequest;
import com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;
    @Autowired
    BoardRepo boardRepo;

    public CardResponse addCardToBoard(Integer board_id, CardRequest cardRequest) throws ChangeSetPersister.NotFoundException {
        Optional<BoardModel> optionalBoard = boardRepo.findById(board_id);
        if (optionalBoard.isPresent()) {
            BoardModel boardModel = optionalBoard.get();

            CardModel cardModel = new CardModel();
            cardModel.setTitle(cardRequest.getTitle());
            cardModel.setDescription(cardRequest.getDescription());
            cardModel.setSection(cardRequest.getSection());
            cardModel = cardRepo.save(cardModel);
            boardModel.getCards().add(cardModel.getCard_id().toString());
            boardRepo.save(boardModel);
            CardResponse cardResponse = new CardResponse(cardModel);
            cardResponse.setCard_id(Math.toIntExact(cardModel.getCard_id()));
            cardResponse.setTitle(cardModel.getTitle());
            cardResponse.setDescription(cardModel.getDescription());
            cardResponse.setSection(cardModel.getSection());
            return cardResponse;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }


    public List<CardResponse> getAllCardsFromBoard(Integer board_id) throws ChangeSetPersister.NotFoundException {
        Optional<BoardModel> optionalBoard = boardRepo.findById(board_id);
        if (optionalBoard.isPresent()) {
            BoardModel boardModel = optionalBoard.get();
            List<CardResponse> cardResponses = new ArrayList<>();

            for (String cardId : boardModel.getCards()) {
                Optional<CardModel> optionalCard = cardRepo.findById((int) Long.parseLong(cardId));
                optionalCard.ifPresent(cardModel -> cardResponses.add(new CardResponse(cardModel)));
            }
            return cardResponses;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
    public CardResponse getCardFromBoardById(Integer board_id, Long card_id) throws ChangeSetPersister.NotFoundException {
        Optional<BoardModel> optionalBoard = boardRepo.findById(board_id);
        if (optionalBoard.isPresent()) {
            BoardModel boardModel = optionalBoard.get();
            Optional<CardModel> optionalCard = cardRepo.findById(Math.toIntExact(card_id));
            if (optionalCard.isPresent()) {
                CardModel cardModel = optionalCard.get();
                return new CardResponse(cardModel);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

}
