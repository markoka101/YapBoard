package YapBoard.service;

import YapBoard.entity.Posts;
import YapBoard.entity.Tags;
import YapBoard.repository.TagsRepository;
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
public class TagsServiceImpl implements TagsService{
    TagsRepository tagsRepository;
    //create tag
    @Override
    public void createTag(Tags tags) {
        tagsRepository.save(tags);
    }

    //find all tags
    @Override
    public List<Tags> getAllTags(int page,String direction) {
        Pageable pageable;

        //how it will be sorted
        if (direction.equals("asc")) {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.ASC,"tag"));
        } else {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.DESC,"tag"));
        }
        Page<Tags> tagPage = tagsRepository.findAll(pageable);
        return tagPage.getContent();
    }

    //see if tag exists
    @Override
    public boolean tagExists(String tags) {
        Tags tag = unwrapTag(tagsRepository.findByTag(tags));
        return tags == null;
    }

    //add post set in tags
    @Override
    public void addPostToTags(Posts post,Tags tags) {
        tags.getPosts().add(post);
        tagsRepository.save(tags);
    }

    //unwrap optional to tags
    static Tags unwrapTag(Optional<Tags> entity) {
        return entity.orElse(null);

    }
}
