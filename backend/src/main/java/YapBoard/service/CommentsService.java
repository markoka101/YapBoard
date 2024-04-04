package YapBoard.service;

import YapBoard.entity.Comments;

import java.util.List;

public interface CommentsService {
    //modifying comments
    void createComment(Comments comments);
    void editComment(Comments comments);
    void deleteComment(Long id);

    //accessing comments
    List<Comments> userComments(Long userId, int page);
    List<Comments> postComments(Long postId, int page);
}
