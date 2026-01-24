package com.weekFive.weekFiveDb.controller;


import com.weekFive.weekFiveDb.service.LibraryService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/api/library")
public class LibraryController {


    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @PostMapping("/borrow")
    public String borrow(@RequestBody Map<String, Long> request) {
        libraryService.borrowBook(request.get("memberId"), request.get("bookId"));
        return "Book borrowed successfully";
    }


    @PostMapping("/return")
    public String returnBook(@RequestBody Map<String, Long> request) {
        libraryService.returnBook(request.get("memberId"), request.get("bookId"));
        return "Book returned successfully";
    }
}