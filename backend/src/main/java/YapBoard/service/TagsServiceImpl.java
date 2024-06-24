package YapBoard.service;

import YapBoard.entity.Tags;
import YapBoard.repository.TagsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagsServiceImpl implements TagsService{
    TagsRepository tagsRepository;
    //create tag
    @Override
    public void createTag(Tags tags) {
        tagsRepository.save(tags);
    }

    //find all tags
    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }
}
