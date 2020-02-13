package org.mumyoutube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.mumyoutube.constants.AppConstant;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.nio.file.Path;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity()
@Table(name = AppConstant.Tb_Video)
public class Video {

    @Id
    @GeneratedValue
    private Long videoId ;
    @NonNull
    private long userId;
    @NotBlank
    private String videoPath;
    private Long no_dislikes = 0l;
    private Long no_likes = 0l;
    private String comment = "";
    private String videoDescription = "";


    @JoinTable
    @OneToMany
    private List<Comment> comments;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Long getNo_dislikes() {
        return no_dislikes;
    }

    public void setNo_dislikes(Long no_dislikes) {
        this.no_dislikes = no_dislikes;
    }

    public Long getNo_likes() {
        return no_likes;
    }

    public void setNo_likes(Long no_likes) {
        this.no_likes = no_likes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoDescription() {
        return this.videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }
}
