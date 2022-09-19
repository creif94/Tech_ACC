package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    //GETS
    @GetMapping("")
    public List<User> getAllUsers(){
      return this.userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){

            return this.userRepo.findById(id).get();

    }

    @PatchMapping("/{id}")
    public User patchUser(@PathVariable Long id, @RequestBody Map<String, String> jsons){
       User something = this.userRepo.findById(id).get();

       jsons.forEach((k,v)-> {
           if (k.equals("password")){
               something.setPassword(v);
           }
           if (k.equals("email")){
               something.setEmail(v);
           }

           if(k.equals("id")){
               something.setId(Long.parseLong(v));
           }
       });
        return userRepo.save(something);
    }


    // POSTS




    @PostMapping("")
    public User adduser(@RequestBody User user){
       return this.userRepo.save(user);
    }

    @PostMapping("/authenticate")
    public AuthenticateDTO authenticate(@RequestBody User user){

        User result = userRepo.findByEmail(user.getEmail());
        Boolean authenticated = user.getPassword().equals(result.getPassword());


        return new AuthenticateDTO(result, authenticated);
    }

    // Deletes

    @DeleteMapping("/{id}")
    public Map<String, Long> deleteUser(@PathVariable Long id){
        Map<String, Long> result = new HashMap<>();
        this.userRepo.deleteById(id);
        result.put("count", this.userRepo.count());
        return result;


    }

}
