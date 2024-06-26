package YapBoard.service;

import YapBoard.entity.Posts;
import YapBoard.entity.Tags;

import java.util.List;

public interface TagsService {
    void createTag(Tags tags);
    void addPostToTags(Posts post, Tags tags);
    List<Tags> getAllTags(int page,String direction);
    boolean tagExists(String tags);
}
