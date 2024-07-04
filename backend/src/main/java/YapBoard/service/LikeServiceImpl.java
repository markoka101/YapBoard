package YapBoard.service;

import YapBoard.entity.Like;
import YapBoard.repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService{
    LikeRepository likeRepository;
    @Override
    public void likePost(Like like) {
        likeRepository.save(like);
    }

    @Override
    public void deleteLiked(Like like) {
        likeRepository.delete(like);
    }

    @Override
    public boolean isLiked(Long userId,Long postId) {
        Optional<Like> like = likeRepository.findByUserAndPost(userId,postId);
        return like.isPresent();
    }

    @Override
    public List<Like> getLikedPosts(Long userId, int page,String direction) {
        Pageable pageable;
        //how it will be ordered
        if (direction.equals("asc")) {
            pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.ASC));
        } else {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.DESC));
        }

        Page<Like> likes = likeRepository.findAllByUser(userId,pageable);
        return likes.getContent();
    }

    @Override
    public List<Like> getPostLikes(Long postId, int page, String direction) {
        Pageable pageable;
        //how it will be ordered
        if(direction.equals("asc")) {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.ASC));
        } else{
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.DESC));
        }

        Page<Like> likes = likeRepository.findAllByPost(postId,pageable);
        return likes.getContent();
    }
}
