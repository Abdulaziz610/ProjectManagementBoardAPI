package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    String title;
    @ElementCollection
    List<String> cards;
    Date  newDate;
    Date update_date;
    Boolean isActive;

    public void setUpdateDate(Date date) {
    }
}
