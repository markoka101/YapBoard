package YapBoard.service;

import YapBoard.entity.Follow;

public interface FollowService {
    //modify follow
    void followUser(Follow follow);
    void unfollow(Follow follow);
}
