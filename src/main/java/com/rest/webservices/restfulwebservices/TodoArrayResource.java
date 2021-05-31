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
public class TodoArrayResource {
    
    @Autowired
    private TodoHardCodedService TodoService;
    
    @GetMapping(path = "/todos/{id}")
    public List<Todo> getTodos(@PathVariable long id){
        return TodoService.findById(id);
    }

    @DeleteMapping("/todos/{maintodoid}/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long maintodoid, @PathVariable long id)
    {
        Todo todo = TodoService.deleteTodoById(id, maintodoid);
        if(todo!= null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/todos/{maintodoid}/{id}")
    public Todo getTodo(@PathVariable long maintodoid,@PathVariable long id){
        return TodoService.findSubTodo(maintodoid, id);
    }

    @PutMapping("/todos/{maintodoid}/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long maintodoid,@PathVariable long id, @RequestBody Todo todo){
        Todo todoupdated = TodoService.save(maintodoid, todo);
        return new ResponseEntity<Todo>(todoupdated,HttpStatus.OK);
    }

    @PostMapping("/todos/{maintodoid}")
    public ResponseEntity<Void> updateTodo(@PathVariable long maintodoid, @RequestBody Todo todo){
        Todo createTodo = TodoService.save(maintodoid, todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
        buildAndExpand(createTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }
}
