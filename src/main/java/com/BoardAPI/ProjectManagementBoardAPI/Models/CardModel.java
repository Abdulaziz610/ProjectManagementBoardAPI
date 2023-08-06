package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Data
@Entity
@DynamicUpdate
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long card_id;
    String title;
    String description;
    Integer section;
    Date newDate;
    @LastModifiedDate
    Date updateDate;
    Boolean isActive;
}
