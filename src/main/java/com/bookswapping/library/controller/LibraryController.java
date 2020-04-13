package com.bookswapping.library.controller;

import com.bookswapping.library.domain.LibraryNotFoundException;
import com.bookswapping.library.domain.dto.LibraryDto;
import com.bookswapping.library.mapper.LibraryMapper;
import com.bookswapping.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1")
public class LibraryController {

    @Autowired
    LibraryMapper libraryMapper;

    @Autowired
    LibraryService libraryService;

    @RequestMapping(method = RequestMethod.GET, value = "/libraries")
    public List<LibraryDto> getLibraryList() {
        return libraryMapper.mapToLibraryDtoList(libraryService.getAllLibraries());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/libraries/{libraryId}")
    public LibraryDto getLibrary(@PathVariable Long libraryId) throws LibraryNotFoundException {
        return libraryMapper.mapToLibraryDto(libraryService.getLibrary(libraryId).orElseThrow(LibraryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/libraries", consumes = APPLICATION_JSON_VALUE)
    public void createLibrary(@RequestBody LibraryDto libraryDto) {
        libraryService.saveLibrary(libraryMapper.mapToLibrary(libraryDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/libraries/{libraryId}")
    public void deleteLibrary(@PathVariable Long libraryId) {
        libraryService.deleteLibrary(libraryId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/libraries")
    public LibraryDto updateLibrary (@RequestBody LibraryDto libraryDto) {
        return libraryMapper.mapToLibraryDto(libraryService.saveLibrary(libraryMapper.mapToLibrary(libraryDto)));
    }
}
