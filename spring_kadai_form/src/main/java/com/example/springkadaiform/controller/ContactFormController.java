package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	// お問い合わせフォーム画面を表示
	@GetMapping("/form")
	public String form(Model model) {
		// ビューに空のフォームクラスのインスタンスを渡す
		if (!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
			}
			
			return "contactFormView";
		}
	
	// 入力内容を受け取ってバリデーションを行って確認画面へ進
	@PostMapping("/confirm")
	public String confirm(@Validated 
						  ContactForm contactForm, 
						  BindingResult result,
						  RedirectAttributes redirectAttributes) {
		
		// バリデーションエラーの場合
		if (result.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			// 元のフォーム画面に戻す
			return "redirect:/form";
		}
		
		
		// バリデーションOKの場合に確認画面を表示
		return "confirmView"; // confirmView.html を表示
	}

}
