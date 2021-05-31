package com.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos =  new ArrayList<>();
    private static int idcounter = 0;
    

    static{
        
        todos.add(new Todo(++idcounter, "Shyam", "Learn Java",  new Date(), false,1));
        todos.add(new Todo(++idcounter, "Radha", "Learn Angular",  new Date(), false,1));
        todos.add(new Todo(++idcounter, "Krishna", "Learn Spring Boot", new Date(), false,1));
        todos.add(new Todo(++idcounter, "Shyam_new", "Learn Java",  new Date(), false,2));
        todos.add(new Todo(++idcounter, "Radha_new", "Learn Angular",  new Date(), false,2));
        todos.add(new Todo(++idcounter, "Krishna_new", "Learn Spring Boot", new Date(), false,2));
    }
    public List<Todo> findall(){
        return todos;
    }
    
    
    public Todo deleteTodoById(long id, long maintodoid){
        List<Todo> todostamp = findById(maintodoid);
        Todo todo = findSubTodoById(id, todostamp);
        if(todo == null) return null;
        // int indextodo = todos.indexOf(todo);
        if(todos.remove(todo) 
        // != null
        ){
            return todo;
        }
        return null;
    }
    private Todo deleteSubTodoById(long id){
        Todo todo = findSubTodoById(id, todos);
        if(todo == null) return null;
        // int indextodo = todos.indexOf(todo);
        if(todos.remove(todo) 
        // != null
        ){
            return todo;
        }
        return null;
    }

    public Todo findSubTodo(long maintodoid, long id){
        List<Todo> todotemp = findById(maintodoid);
        Todo todo = findSubTodoById(id, todotemp);
        return todo;
    }

    public List<Todo> findById(long id) {
        List<Todo> todostemp =  new ArrayList<>();
        for(Todo todo: todos){
            if(todo.getTodo() == id){
                todostemp.add(todo);                
            }
            
        } 
        return todostemp;
    }
    
    public Todo findSubTodoById(long id, List<Todo> subtodos) {
        for(Todo todo: subtodos){
            if(todo.getId() == id){
                return todo;                
            }
            
        } 
        return null;
    }
    
    public Todo save(long maintodoid, Todo todo){
        if(todo.getId()==-1 || todo.getId() == 0){
            todo.setId(++idcounter);
            todo.setTodo(maintodoid);
            todos.add(todo);
        }else{
            deleteSubTodoById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
    
}
