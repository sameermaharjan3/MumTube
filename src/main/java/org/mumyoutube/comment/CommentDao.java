package org.mumyoutube.comment;

import org.mumyoutube.model.Comment;
import org.mumyoutube.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class CommentDao implements ICommentDao {

    @Autowired
    private JdbcTemplate jdbcTemp;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComment() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllComment(int videoId) {
//        return commentRepository.
//        for(Comment comment: commentRepository.findAll())
        List<Comment> list = new ArrayList<>();
        for(Comment comment: commentRepository.findAll()){
            if(comment.getVideoId()==videoId){
                list.add(comment);
            }
        }
        return list;
    }

    public List<Comment> getCommentByVideoId(int videoId) {
        return commentRepository.getCommentByVideoId(videoId);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
    }
}
