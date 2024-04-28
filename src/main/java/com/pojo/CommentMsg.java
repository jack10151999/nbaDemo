package com.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentMsg implements Serializable {
    private int postId; // 文章 id
    private int creatorId; // 留言建立者 id
    private String content; // 留言內容

}