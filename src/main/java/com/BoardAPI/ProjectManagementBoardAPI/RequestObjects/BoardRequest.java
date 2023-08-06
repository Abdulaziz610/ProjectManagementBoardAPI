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
    String name;

}


