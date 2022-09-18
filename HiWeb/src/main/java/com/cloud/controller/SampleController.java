package com.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.SampleVO;
import com.cloud.domain.Ticket;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/sample")
public class SampleController {
	
	//���ڿ� ����
	@GetMapping(value="/getText", produces="text/plain; charset=utf-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "�ȳ�~ REST";  //"Hello~ REST" , �ѱ��� ��� ???�� ���
	}
	
	//VO ��ü ����
	@GetMapping(value="/getSample", 
			    produces= {MediaType.APPLICATION_JSON_VALUE,
			    		   MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "�⽺", "��Ƽ��");
	}
	
	//�÷���(����Ʈ) ���� 
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10)
						.mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
						.collect(Collectors.toList());
	}
	
	//�÷���(Map) ����
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(112, "Bill", "Gates"));
		return map;
	}
	
	//�迭�� ���� - URL ��� �Ϻθ� �Ķ���ͷ� ���
	@GetMapping("/product/{cat}/{pid}")
	public String[] getpath(
			@PathVariable("cat") String cat, 
			@PathVariable("pid") String pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
	//@RequestBody�� ticket ��ü Ÿ������ ��ȯ�� �䱸�� - PostMapping ����!
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert..........ticket" + ticket);
		return ticket;
	}
}









