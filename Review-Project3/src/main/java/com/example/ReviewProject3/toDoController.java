package com.example.ReviewProject3;

import com.example.ReviewProject3.Exceptions.APIExceptionSuperClass;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/toDo")
public class toDoController {

    toDoRepo repo;
    public toDoController(toDoRepo repo){
        this.repo = repo;
    }

    @GetMapping("")
    public List<toDo> gettingAllTasks(){
        return this.repo.findAll();
    }
    @GetMapping("/{id}")
    public toDo getTaskById(@PathVariable Long id){
        try{
            Optional<toDo> task = this.repo.findById(id); // Will still return a Optional even if there is no task.
            if(task.isPresent()) {
                return this.repo.findById(id).get();
            }
        } catch (NoSuchElementException e) {
            throw new APIExceptionSuperClass("Element Already Exists",e);
        }
        return null;
    }
    @PostMapping("")
    public toDo postTask(@RequestBody toDo task){
        try{
//            if (task.getDescription() == null && task.getDueDate() == null && task.getPriority() ==null)
            return this.repo.save(task);
        }
        catch(IllegalArgumentException e){
            throw new APIExceptionSuperClass("",e);
        }

    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        try{
            Optional<toDo> task = this.repo.findById(id); // Will still return a Optional even if there is no task.
            if(task.isPresent()) {
                System.out.println("Task Deleted");
                this.repo.deleteById(id);
            } else{throw new NoSuchElementException();}
        } catch (Exception e) {
            throw new APIExceptionSuperClass("Task Did Not Exist, so No Deletion Occured",e);
        }

    }
    @PatchMapping("{id}")
    public toDo patchTask(@PathVariable Long id, @RequestBody Map<String, String> vars){
        Optional<toDo> Task = this.repo.findById(id);
        try{
            if(Task.isPresent()){
                vars.forEach((k, v) ->{
                    if(k.equals("description")){
                        Task.get().setDescription(v);
                    }
                    if(k.equals("dueDate")){
                        Task.get().setDueDate(v);
                    }
                    if(k.equals("priority")){
                        Task.get().setPriority(v);
                    }
                });
            }else{throw new NoSuchElementException();}
        }
        catch(NoSuchElementException e){
                throw new APIExceptionSuperClass("Task did Not exist",e);}

        return null;
        }
}


