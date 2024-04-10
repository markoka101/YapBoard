package YapBoard.service;

import YapBoard.entity.Comments;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService{
    @Override
    public void createComment(Comments comments) {

    }

    @Override
    public void editComment(Comments comments) {

    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public List<Comments> userComments(Long userId, int page) {
        return null;
    }

    @Override
    public List<Comments> postComments(Long postId, int page) {
        return null;
    }
}
