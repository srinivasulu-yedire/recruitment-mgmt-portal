package org.bits.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.bits.springboot2.crud.exception.ResourceNotFoundException;
import org.bits.springboot2.crud.model.Recruitment;
import org.bits.springboot2.crud.repository.RecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RecruitmentController {
	@Autowired
	private RecruitmentRepository recruitmentRepository;

	@GetMapping("/recruitments")
	public List<Recruitment> getAllRecruitments() {
		return recruitmentRepository.findAll();
	}

	@GetMapping("/recruitments/{id}")
	public ResponseEntity<Recruitment> getRecruitmentById(@PathVariable(value = "id") Long recruitmentId)
			throws ResourceNotFoundException {
		Recruitment rec = recruitmentRepository.findById(recruitmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Recruitment not found for this id :: " + recruitmentId));
		return ResponseEntity.ok().body(rec);
	}

	@PostMapping("/recruitments")
	public Recruitment createRecruitment( @RequestBody Recruitment rec) {
		return recruitmentRepository.save(rec);
	}

	@PutMapping("/recruitments/{id}")
	public ResponseEntity<Recruitment> updateRecruitment(@PathVariable(value = "id") Long recruitmentId,
			 @RequestBody Recruitment employeeDetails) throws ResourceNotFoundException {
		Recruitment rec = recruitmentRepository.findById(recruitmentId)
				.orElseThrow(() -> new ResourceNotFoundException("recruitment not found for this id :: " + recruitmentId));

		rec.setRecruitmentTechnology(employeeDetails.getRecruitmentTechnology());
		rec.setRecruitmentLocation(employeeDetails.getRecruitmentLocation());
		rec.setDepartment(employeeDetails.getDepartment());
		final Recruitment updatedEmployee = recruitmentRepository.save(rec);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/recruitments/{id}")
	public Map<String, Boolean> deleteRecruitment(@PathVariable(value = "id") Long recruitmentId)
			throws ResourceNotFoundException {
		Recruitment rec = recruitmentRepository.findById(recruitmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Recruitment not found for this id :: " + recruitmentId));

		recruitmentRepository.delete(rec);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
