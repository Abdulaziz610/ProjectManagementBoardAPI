package com.BoardAPI.ProjectManagementBoardAPI.Models;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    String title;
    @ElementCollection
    List<String> cards;
}
