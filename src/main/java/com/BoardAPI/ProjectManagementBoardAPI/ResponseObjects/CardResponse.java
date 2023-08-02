package com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects;


import com.BoardAPI.ProjectManagementBoardAPI.Models.CardModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CardResponse {
    Integer card_id;
    String title;
    String description;
    Integer section;
    public CardResponse(CardModel cardModel) {
        this.card_id = Math.toIntExact(cardModel.getCard_id());
        this.title = cardModel.getTitle();
        this.description = cardModel.getDescription();
        this.section = cardModel.getSection();
    }
}
