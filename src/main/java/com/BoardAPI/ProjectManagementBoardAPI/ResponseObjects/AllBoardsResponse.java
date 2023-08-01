package com.BoardAPI.ProjectManagementBoardAPI.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class AllBoardsResponse {
    List<BoardResponse> boards;
}
