package com.example.QuizApplication;

import com.example.QuizApplication.auth.AuthenticationRequest;
import com.example.QuizApplication.auth.AuthenticationResponse;
import com.example.QuizApplication.auth.RegisterRequest;
import com.example.QuizApplication.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Controller
@RequestMapping("/quiz-app")
public class QuizApplication {


	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(QuizApplication.class);
		SpringApplication.run(QuizApplication.class, args);
	}

	public WebClient webClient(){
		return  WebClient.builder().build();
	}

	@GetMapping
	public String index(Model model, HttpServletRequest request) {
		if ((String) request.getSession().getAttribute("access_token") == null) {
			return "redirect:/quiz-app/signin-page";
		}

		return "index";
	}

	@GetMapping("/signin-page")
	public String signIn(){
		return "SignIn";
	}

	@GetMapping("/signup-page")
	public String singup(){
		return "signUp";
	}

	@PostMapping("/signup")
	public String register(HttpServletRequest request){

		RegisterRequest registerRequest = new RegisterRequest(request.getParameter("username"),request.getParameter("email"),request.getParameter("password"));

		AuthenticationResponse authResponse =
			webClient()
				.post()
				.uri("http://localhost:8080/api/v1/auth/register")
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(registerRequest), RegisterRequest.class)
				.retrieve()
				.bodyToMono(AuthenticationResponse.class)
				.block();

		HttpSession session = request.getSession();
		session.setAttribute("access_token", authResponse.getToken());

		return "redirect:/quiz-app";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request){
		AuthenticationRequest authenticationRequest = new AuthenticationRequest(request.getParameter("email"),request.getParameter("password"));

		AuthenticationResponse authResponse =
			webClient()
				.post()
				.uri("http://localhost:8080/api/v1/auth/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(authenticationRequest), AuthenticationRequest.class)
				.retrieve()
				.bodyToMono(AuthenticationResponse.class)
				.block();

		HttpSession session = request.getSession();
		session.setAttribute("access_token", authResponse.getToken());

		return "redirect:/quiz-app";

	}

	@GetMapping("logout")
	public String logOut(HttpServletRequest request) {
		request.getSession().setAttribute("access_token", null);
		return "redirect:/quiz-app/signin-page";
	}

}
