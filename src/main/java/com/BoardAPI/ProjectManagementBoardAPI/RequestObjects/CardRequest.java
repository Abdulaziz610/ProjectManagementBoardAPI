package com.BoardAPI.ProjectManagementBoardAPI.RequestObjects;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CardRequest {
         String title;
         String description;
         Integer section;
}
