package com.codepresso.todo.controller;

import java.util.ArrayList;
import java.util.List;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;
@RestController
public class TodoController {

    //Hãy viết code Dependency injection để ứng dụng TodoService
    private  TodoService  todoService;
    public TodoController (TodoService todoService){
        this.todoService = todoService;
    }





    //todo Kiểm tra API document rồi sử dụng phương thức GET để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @GetMapping("/todo")
    @ResponseBody
    public List<Todo> getTodoList(){
        List<Todo> list = todoService.getTodoList();
        return list;
    }

    //todo Kiểm tra API document rồi sử dụng phương thức POST để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @PostMapping("/todo")
    @ResponseBody
    public ResultDto addTodo(@RequestBody Todo todoParam) {
        Todo todo = new Todo(todoParam.getContent());
        todoService.addTodo(todo);
        return new ResultDto(200, "Success");
    }

    //todo Kiểm tra API document rồi sử dụng phương thức DELETE để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @DeleteMapping("/todo/{id}")
    public ResultDto deleteTodo(@PathVariable("id") String id) {
        todoService.deleteTodo(Integer.parseInt(id));
        return new ResultDto(200, "Success");
    }

}
