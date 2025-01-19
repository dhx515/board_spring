package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "board_file_table")
public class BoardFileEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    public static BoardFileEntity toBoardFileEntity(BoardEntity boardEntity, String originFileName, String storedFileName) {
        BoardFileEntity boardFileEntity = new BoardFileEntity();
        boardFileEntity.setBoardEntity(boardEntity);
        boardFileEntity.setOriginFileName(originFileName);
        boardFileEntity.setStoredFileName(storedFileName);

        return boardFileEntity;
    }
}
