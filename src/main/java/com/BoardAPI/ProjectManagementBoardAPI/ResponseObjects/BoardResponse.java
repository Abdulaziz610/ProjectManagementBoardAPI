package com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects;


import com.BoardAPI.ProjectManagementBoardAPI.Models.BoardModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder

public class BoardResponse {

    Integer board_id;
    String name;
    Map<Integer, String> columns;
    List<String> column;
}