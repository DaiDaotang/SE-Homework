package com.know.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int commenterId;
    private int commentedId;
    private String commentContent;
    private int commentLiked;
    private int answerId;
    private String commentTime;
}
