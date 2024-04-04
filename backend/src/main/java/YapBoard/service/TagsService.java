package YapBoard.service;

import YapBoard.entity.Tags;

import java.util.List;

public interface TagsService {
    void createTag(Tags tags);
    List<Tags> getAllTags();
}
