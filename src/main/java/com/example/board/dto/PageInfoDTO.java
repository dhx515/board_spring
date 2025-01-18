package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageInfoDTO {

    private int startPage;
    private int endPage;
    private int totalPages;
}
