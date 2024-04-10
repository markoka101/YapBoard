package YapBoard.service;

import YapBoard.entity.Tags;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagsServiceImpl implements TagsService{
    @Override
    public void createTag(Tags tags) {

    }

    @Override
    public List<Tags> getAllTags() {
        return null;
    }
}
