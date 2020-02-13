package org.mumyoutube.comment;

import org.mumyoutube.model.Comment;
import org.mumyoutube.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> getCommentByVideoId(int videoId);

}
