package com.spring.pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pr.board.service.IBoardService;
import com.spring.pr.command.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//�� ��� ���� ��ûó��
	@GetMapping("/boardList")
	public void BoardList(Model model) {
		model.addAttribute("bList", service.getList());
	}
	
	//�� �ۼ� ������ �̵� ��û ó��
	@GetMapping("/boardRegist")
	public void BoardRegist() {
	}
	
	//�� ��� ��û ó��
	@PostMapping("/boardRegist")
	public String BoardRegist(BoardVO vo) {
		service.regist(vo);
		return "redirect:/board/boardList";
	}
	
}
