package com.bigProject.tellMe.controller.complaint;

import com.bigProject.tellMe.dto.QuestionDTO;
import com.bigProject.tellMe.entity.Question;
import com.bigProject.tellMe.entity.User;
import com.bigProject.tellMe.enumClass.Status;
import com.bigProject.tellMe.service.QuestionService;
import com.bigProject.tellMe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/complaint")
@RequiredArgsConstructor
public class ComplaintController {
    private final UserService userService;
    private final QuestionService questionService;

    @GetMapping("/new")
    public String newComplaintForm(Authentication auth, Model model) {
        System.out.println("=============================");
        System.out.println(auth.getName());
        //User user = userService.findByUserId(auth.getName());
        //model.addAttribute("user_id", user.getId());

        return "complaint/new";
    }

    @PostMapping("/create")
    public String createComplaint(Authentication auth, QuestionDTO questionDTO) {
        User user = userService.findByUserId(auth.getName());

        System.out.println(questionDTO.toString());
        questionDTO.setUserId(user.getId());
        questionDTO.setStatus(Status.처리중);

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Question saved = questionService.save(questionDTO);

        return "customer/board";
    }
}
