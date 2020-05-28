package com.know.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date commentTime;
}
