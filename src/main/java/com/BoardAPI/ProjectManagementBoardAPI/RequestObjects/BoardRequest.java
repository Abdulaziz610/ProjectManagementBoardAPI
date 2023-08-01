package com.BoardAPI.ProjectManagementBoardAPI.RequestObjects;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class BoardRequest {

    String title;

  //  List<String> boardCards;


    /*
     *
     * Request object for creating a board
     * It contains fields representing the board's title and list of cards.
     *
     * */

/*
    public static BoardModel convertToEntity(BoardModel entity, BoardRequest boardRequest) {

        entity.setTitle(boardRequest.getBoardTitle());
        entity.setCards(boardRequest.getBoardCards());
        return entity;


    }


 */
}
