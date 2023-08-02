package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    String title;
    @ElementCollection
    List<String> cards;
    Date newDate;
    Date update_date;
    Boolean isActive;

    public void setUpdateDate(Date date) {
    }
}
