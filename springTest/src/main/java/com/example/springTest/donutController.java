package com.example.springTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import com.example.springTest.ExceptionHandling.ExcpetionSuper;

@RestController
@RequestMapping("/donut")
public class donutController {

    donutRepo repo;

    public donutController(donutRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<donut> getDonutAll() {
        //Trying to return all of the Donuts in the donut_db
        try {
            return repo.findAll();
        }
        //If failed, return the custom exception, Throw new Error inside ExcpetionSuper
        catch (Exception e) {
            throw new ExcpetionSuper("Error with getting all Donuts");
        }
    }

    @GetMapping("/{id}")
    //Though the first public... did work, the exception handling was off...
//    public Optional<donut> getDonutById(@PathVariable("id") Long id) {
    public donut getDonutById(@PathVariable("id") Long id) {
        //Trying to return the Donut with the given id
        try {
            Optional<donut> donuts = this.repo.findById(id);
            if (donuts.isPresent()) {
                return repo.findById(id).get();
            }else{
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) { // IllegalArgumentException will catch any paramaters inside the JSON that aren't correctly formatted
            throw new ExcpetionSuper("Donut was not There");
        }
    }


    //Posting a new instance of a Donut
    @PostMapping("")
    public donut createDonut(@RequestBody donut donut) {
        try {
            return repo.save(donut);
        }
        //If failed, return the custom exception, Throw new Error inside ExcpetionSuper
        catch (IllegalArgumentException e) { // IllegalArgumentException will catch any paramaters inside the JSON that aren't correctly formatted
            throw new ExcpetionSuper("Did not save a Donut");
        }
    }
    //Posting a batch of new donuts
    @PostMapping("batch")
    public List<donut> createDonuts(@RequestBody List<donut> donuts) {
        try {
            return repo.saveAll(donuts);
        } catch (IllegalArgumentException e) {
            throw new ExcpetionSuper("Did not save a batch of Donuts");
        }
    }
    //Deleting a Single Donut
//    @DeleteMapping("/{id}")
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > deleteDonut(@PathVariable("id") Long id) {
        //Trying to delete the Donut with the given id
        try {
            Optional<donut> donut = this.repo.findById(id);
            if (donut.isPresent()){
                this.repo.deleteById(id);
                return new ResponseEntity<String>("{ \n \"context\": \"Successfully Deleted\" }", HttpStatus.OK);

            }else{
                throw new ExcpetionSuper("Donut was not Found");
            }
        }catch (IllegalArgumentException e) {
            throw new ExcpetionSuper("Did not delete a Donut");
        }
    }

    @PatchMapping("/{id}")
    public donut updateDonut(@PathVariable("id") Long id, @RequestBody Map<String, Object> vars) {
        //Trying to update the Donut with the given id
        try {
            Optional<donut> donuts = this.repo.findById(id);
            if (donuts.isPresent()) {
                vars.forEach((k, v) -> {
                    if(k.equals("name")){
                        donuts.get().setName((String)v);
                    }
                    if(k.equals("topping")){
                        donuts.get().setTopping((String)v);
                    }
                    if(k.equals("experation")){
                        donuts.get().setExperation((String)v);
                    }
                });
            } else{
            throw new NoSuchElementException();
            }
        }catch(IllegalArgumentException e){
            throw new ExcpetionSuper("Error with the JSON, prob a Null");
        }catch (NoSuchElementException e){
            throw new ExcpetionSuper("Donut was not Found");
        }
        return this.repo.findById(id).get();

    }
}
