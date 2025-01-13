# 게시판 프로젝트 README

## 01. 개발환경
- **IDE**: IntelliJ IDEA Community Edition
- **Framework**: Spring Boot 3.4.1
- **JDK**: 17
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Template Engine**: Thymeleaf

## 02. 게시판 주요 기능

### 1.  글쓰기
```
• Endpoint: /board/save
• 사용자가 제목과 내용을 입력하여 게시글 작성.
```
### 2.	글목록
```
• Endpoint: /board/
• 등록된 게시글의 목록을 페이징 처리 없이 출력.
```
### 3.	글조회
```
• Endpoint: /board/{id}
• 특정 게시글의 상세 내용을 출력.
```
### 4.	글수정
```
• Endpoint: /board/update/{id}
• 상세 화면에서 수정 버튼 클릭 → 서버에서 해당 게시글 정보를 가져와 수정 화면 출력.
• 제목, 내용을 수정 후 저장 요청 시 게시글 정보 갱신.
```
### 5.	글삭제
```
• Endpoint: /board/delete/{id}
• 특정 게시글을 삭제.
```
### 6.	페이징 처리
```
• Endpoints:
    - /board/paging?page=2
    - /board/paging/2
• 설명:
  게시글 수: 14
  페이징 조건:
    - 한 페이지당 5개씩 출력 → 총 3페이지
    - 한 페이지당 3개씩 출력 → 총 5페이지
```
### 7.	파일(이미지) 첨부
```
• 단일 및 다중 파일 첨부 가능.
• 변경사항:
    • 파일 첨부 기능을 위해 다음 항목 수정/추가:
        - HTML 파일: save.html, detail.html
        - DTO: BoardDTO
        - Service: BoardService.save()
        - Entity: BoardEntity, BoardFileEntity
        - Repository: BoardFileRepository
```

## 03. 데이터베이스 테이블 설계

### 게시글 테이블 (board_table)
```sql
CREATE TABLE board_table (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_time   DATETIME NULL,
    updated_time   DATETIME NULL,
    board_contents VARCHAR(500) NULL,
    board_hits     INT NULL,
    board_pass     VARCHAR(255) NULL,
    board_title    VARCHAR(255) NULL,
    board_writer   VARCHAR(20) NOT NULL,
    file_attached  INT NULL
);
```
### 파일 테이블 (board_file_table)
```sql
CREATE TABLE board_file_table (
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_time       DATETIME NULL,
    updated_time       DATETIME NULL,
    original_file_name VARCHAR(255) NULL,
    stored_file_name   VARCHAR(255) NULL,
    board_id           BIGINT NULL,
    CONSTRAINT FKcfxqly70ddd02xbou0jxgh4o3
    FOREIGN KEY (board_id) REFERENCES board_table (id) ON DELETE CASCADE
);
```

### MySQL 데이터베이스 계정 생성 및 권한 부여
```sql
CREATE DATABASE db_board_spring;

CREATE USER 'user_board_spring'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON db_board_spring.* TO 'user_board_spring'@'localhost';
```

## 04. 코드 변경사항 확인
```
파일 첨부와 관련된 변경 사항은 소스 코드에서 자세히 확인할 수 있습니다. 

각 파일 및 메서드에서 추가된 부분을 참고해주세요.
```