package mk.finki.ukim.mk.emt.config;


import mk.finki.ukim.mk.emt.model.Country;
import mk.finki.ukim.mk.emt.model.User;
import mk.finki.ukim.mk.emt.model.dto.AuthorDto;
import mk.finki.ukim.mk.emt.model.dto.BookDto;
import mk.finki.ukim.mk.emt.service.AuthorService;
import mk.finki.ukim.mk.emt.service.BookService;
import mk.finki.ukim.mk.emt.service.UserService;
import mk.finki.ukim.mk.emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {

        this.countryService.save("England", "Europe");
        this.countryService.save("Germany", "Europe");
        this.countryService.save("Italy", "Europe");

        this.authorService.save(new AuthorDto("Albert", "Camus", new Country("Algeria", "Africa")));


    }
}
