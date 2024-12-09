package org.krytev.backendservice.controller;

import lombok.RequiredArgsConstructor;
import org.krytev.backendservice.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/text-storage")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity writeData(@RequestBody String data){
        try {
            mainService.writeData(data);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity readData(){
        try {
            return ResponseEntity.ok(mainService.readData());
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
