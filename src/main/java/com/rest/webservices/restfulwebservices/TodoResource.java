package com.rest.webservices.restfulwebservices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {
    @Autowired
    // private TodoHardCodedService TodoService;
    private TodoArrayHardCodedService TodoArrayService;

    @GetMapping("/welcome")
    // public List<Todo> getAllTodos(){
    //     return TodoService.findall();
    // }
    public List<TodoArray> getAllTodos(){
        return TodoArrayService.getArrayTodos();
    }

    @DeleteMapping("/todo/{id}")
    // public ResponseEntity<Void> deleteTodo(@PathVariable long id)
    // {
    //     Todo todo = TodoService.deleteTodoById(id);
    //     if(todo!= null){
    //         return ResponseEntity.noContent().build();
    //     }
    //     return ResponseEntity.notFound().build();
    // } 
    
    public ResponseEntity<Void> deleteTodo(@PathVariable long id)
    {
        TodoArray todoarray = TodoArrayService.deleteTodoById(id);
        if(todoarray!= null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(path = "/todo/{id}")
    // public Todo getTodo(@PathVariable long id){
    //     return TodoService.findById(id);
    // }
    public TodoArray getTodo(@PathVariable long id){
        return TodoArrayService.findById(id);
    }
    
    @PutMapping("/todo/{id}")
    // public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo){
    //     Todo todoupdated = TodoService.save(todo);
    //     return new ResponseEntity<Todo>(todoupdated,HttpStatus.OK);
    // }
    public ResponseEntity<TodoArray> updateTodo(@PathVariable long id, @RequestBody TodoArray todo){
        TodoArray todoupdated = TodoArrayService.save(todo);
        return new ResponseEntity<TodoArray>(todoupdated,HttpStatus.OK);
    }
    @PostMapping("/todo")
    // public ResponseEntity<Void> updateTodo(@RequestBody Todo todo){
    //     Todo createTodo = TodoService.save(todo);

    //     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
    //     buildAndExpand(createTodo.getId()).toUri();

    //     return ResponseEntity.created(uri).build();

    // }
    public ResponseEntity<Void> updateTodo(@RequestBody TodoArray todo){
        TodoArray createTodo = TodoArrayService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
        buildAndExpand(createTodo.getArrcounter()).toUri();

        return ResponseEntity.created(uri).build();

    }
}
