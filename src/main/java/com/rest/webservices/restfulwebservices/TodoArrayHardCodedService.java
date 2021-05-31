package com.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoArrayHardCodedService {

    public static List<TodoArray> todosarr = new ArrayList<>();
    public static long idcounter = 0;

    static {
        
        todosarr.add(new TodoArray(++idcounter, "chitti"));
        todosarr.add(new TodoArray(++idcounter, "srikanth"));
    }

    public List<TodoArray> getArrayTodos(){
        return todosarr;
    }
    

    public TodoArray deleteTodoById(long id){
        TodoArray todo = findById(id);
        if(todo == null) return null;
        // int indextodo = todos.indexOf(todo);
        if(todosarr.remove(todo) 
        // != null
        ){
            return todo;
        }
        return null;
    }

    public TodoArray findById(long id) {
        for(TodoArray todo: todosarr){
            if(todo.getArrcounter() == id){
                return todo;
            }
        }    
        return null;
    }
    
    public TodoArray save(TodoArray todo){
        if(todo.getArrcounter()==-1 || todo.getArrcounter() == 0){
            todo.setArrcounter(++idcounter);
            todosarr.add(todo);
        }else{
            deleteTodoById(todo.getArrcounter());
            todosarr.add(todo);
        }
        return todo;
    }
}
