package org.mumyoutube.comment;

import org.mumyoutube.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getAllComment() {
        return commentDao.getAllComment();
    }

    @Override
    public List<Comment> getAllComment(int videoId) {
        return commentDao.getAllComment(videoId);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        commentDao.deleteComment(commentId);
    }
}
