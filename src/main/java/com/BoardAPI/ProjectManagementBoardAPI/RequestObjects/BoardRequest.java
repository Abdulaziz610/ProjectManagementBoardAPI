package com.BoardAPI.ProjectManagementBoardAPI.RequestObjects;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class BoardRequest {
    String boardTitle;
    List<String> boardCards;
}
