package am.itspace.restexample.endpoint;
import am.itspace.restexample.dto.AuthorResponseDto;
import am.itspace.restexample.dto.CreateAuthorDto;
import am.itspace.restexample.mapper.AuthorMapper;
import am.itspace.restexample.model.Author;
import am.itspace.restexample.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class AuthorEndpoint {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @GetMapping("/authors")
    public List<AuthorResponseDto> getAllAuthors() {
        return authorMapper.map(authorRepository.findAll());
    }
    @PostMapping("/authors")
    public ResponseEntity<?> createAuthor(@RequestBody CreateAuthorDto createAuthorDto) {
        Author savedAuthor = authorRepository.save(authorMapper.map(createAuthorDto));
        return ResponseEntity.ok(savedAuthor);
    }
}
