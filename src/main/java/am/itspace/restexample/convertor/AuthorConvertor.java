package am.itspace.restexample.convertor;
import am.itspace.restexample.dto.AuthorResponseDto;
import am.itspace.restexample.dto.CreateAuthorDto;
import am.itspace.restexample.model.Author;
import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.List;
@UtilityClass
public class AuthorConvertor {
    public Author convertDtoToEntity(CreateAuthorDto createAuthorDto) {
        Author author = new Author();
        author.setName(createAuthorDto.getName());
        author.setSurname(createAuthorDto.getSurname());
        author.setEmail(createAuthorDto.getEmail());
        author.setGender(createAuthorDto.getGender());
        return author;
    }
    public AuthorResponseDto convertEntityToResponseDto(Author author) {
        return AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .gender(author.getGender())
                .build();
    }
    public  List<AuthorResponseDto> convertEntitysToResponseDtos(List<Author> all) {
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : all) {
           authorResponseDtos.add(convertEntityToResponseDto(author));
        }
        return authorResponseDtos;
    }
}
