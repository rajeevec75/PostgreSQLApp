package com.PostgreSQLApp.dao;

import com.PostgreSQLApp.model.Author;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao {

    private List<Author> authors = new ArrayList<>();

    public Author getAuthor(String id) {
        return authors.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveAuthor(Author author) {
        authors.add(author);
    }
}
