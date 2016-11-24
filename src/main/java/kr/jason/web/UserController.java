package kr.jason.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.jason.model.Question;
import kr.jason.model.User;

@Controller // C + S + O OR C + 1 : import
public class UserController {
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Question> questions = new ArrayList<>();
	
	@PostMapping("/write")
	public String write(Question question){
		questions.add(question);
		System.out.println("question : "+ question);
		return "redirect:/writes";
	}
	
	@GetMapping("/writes")
	public String qlist(Model model){
		model.addAttribute("questions", questions);
		return "/index";
	}
	
	@GetMapping("/users")
	public String list(Model model){
		model.addAttribute("users", users);
		return "/user/list";
	}
	@PostMapping("/user/create")
	public String create(User user){
		users.add(user);
		System.out.println("userId : "+ user.toString()); //ctrl + space : Content Assist
		return "redirect:/users";
	}
}
