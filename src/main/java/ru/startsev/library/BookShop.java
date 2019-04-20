package ru.startsev.library;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookShop {

    @RequestMapping("/book")
    public String getBook() {
        return "Good book";
    }
}
