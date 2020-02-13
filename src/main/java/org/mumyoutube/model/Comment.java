package org.mumyoutube.model;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import lombok.NonNull;
import org.mumyoutube.constants.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = AppConstant.Tb_Comment)
public class Comment {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    @NonNull
    private int userId;

    @NonNull
    private String comment;

    @NonNull
    private int videoId;

    @NonNull
    private String username;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
