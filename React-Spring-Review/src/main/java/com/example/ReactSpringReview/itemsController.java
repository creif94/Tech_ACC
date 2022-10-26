package com.example.ReactSpringReview;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class itemsController {

    itemsRepo repo;
    public itemsController(itemsRepo repo){this.repo = repo;}

    // Get all Items in the List
    @GetMapping("")
    public List<items> getAllItems(){
        return repo.findAll();
    }
    // Get Single Item:
    @GetMapping("/{id}")
    public items getSingleItem(@PathVariable("id") Long id){
        return repo.findById(id).get();
    }

    // PostMapping
    @PostMapping("")
    public ResponseEntity<String> saveItem(@RequestBody items item){
        repo.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("batch")
    public ResponseEntity<String> saveItems(@RequestBody List<items> items){
        repo.saveAll(items);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // Delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id){
        repo.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //Patch Specific Item
    @PatchMapping("{id}")
    public items patchItem(@PathVariable Long id, @RequestBody Map<String, Object> item){
        items singleItem = this.repo.findById(id).get();
        item.forEach((k,v)->{
            if(k.equals("content")){
                singleItem.setContent(String.valueOf(v));
            }
            if (k.equals("completed")){
                singleItem.setCompleted((Boolean)v);
            }
        });
        this.repo.save(singleItem);
        return this.repo.findById(id).get();
    }
}
