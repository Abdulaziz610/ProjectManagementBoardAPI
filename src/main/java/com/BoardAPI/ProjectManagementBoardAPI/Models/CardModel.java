package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long card_id;
    String title;
    String description;
    Integer section;
    Date newDate;
    Date updateDate;
    Boolean isActive;
}
