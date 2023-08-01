package com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class BoardResponse {
    Integer id;
    String boardTitle;
    List<String> boardCards;


    /*
     *
     * Response object for retrieving Board information.
     *
     *
     * */

    public static BoardResponse convertToResponse(BoardModel entity) {
        return BoardResponse.builder()
                .id(entity.getId())
                .boardTitle(entity.getTitle())
                .boardCards(entity.getCards())
                .build();

    }

}
