package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Controller
public class ToDoController {
	@Autowired
	private ToDoRepository toDoRepository;
	
	
	@GetMapping("/todo")
	public String todo(Model model) {
		List<ToDo> todos = toDoRepository.findAll();
		
		model.addAttribute("todos", todos);
		
		return "todoView";
	}

}
