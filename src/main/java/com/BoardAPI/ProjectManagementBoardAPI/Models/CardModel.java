package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String title;
    String description;
    String Section;


    Date newDate;
    Date updateDate;
    Boolean isActive;
}
