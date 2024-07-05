package YapBoard.service;

import YapBoard.entity.Comments;
import YapBoard.repository.CommentsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService{
    CommentsRepository commentsRepository;
    //save comment to repo
    @Override
    public void createComment(Comments comments) {
        commentsRepository.save(comments);
    }

    //edit comment
    @Override
    public void editComment(Comments comments) {
        commentsRepository.save(comments);
    }

    //delete comment
    @Override
    public void deleteComment(Long id) {
        Comments comment = unwrap(commentsRepository.findById(id));
        commentsRepository.delete(comment);
    }

    //find comments from user
    @Override
    public List<Comments> userComments(Long userId, int page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Comments> comments = commentsRepository.findByUser(userId,pageable);
        return comments.getContent();
    }

    //find comments by post
    @Override
    public List<Comments> postComments(Long postId, int page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Comments> comments = commentsRepository.findByPosts(postId,pageable);
        return comments.getContent();
    }

    //unwrap optional comment
    static Comments unwrap(Optional<Comments> entity) {
        if (entity.isPresent()) {
            return entity.get();
        }

        throw new EntityNotFoundException("Comment not found");
    }
}
