package com.codepresso.todo.service;

import java.util.List;

import com.codepresso.todo.vo.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private List<Todo> todoList;

    //todo Hoàn thành code để Dependency injection vào biến thành viên todoList
    public TodoService (List<Todo> todoList){
        this.todoList = todoList;
    }


    public void addTodo(Todo todo) {
        todo.setId(todoList.size());
        todoList.add(todo);
    }

    public List<Todo> getTodoList(){
        return todoList;
    }

    public void deleteTodo(int id) {
        int index = 0;
        for(Todo todo: todoList) {
            if (todo.getId() == id) {
                break;
            }
            index++;
        }

        todoList.remove(index);
    }
}
