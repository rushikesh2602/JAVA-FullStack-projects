package com.Management_System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import javax.print.attribute.standard.Media;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Management_System.doclogin.entity.Medicine;
import com.Management_System.doclogin.repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

	MedicineRepository medicinerepository;

	public MedicineController(MedicineRepository medicinerepository) {
		super();
		this.medicinerepository = medicinerepository;
	}
	
	
	@PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		
		return medicinerepository.save(medicine);
	}
	
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicine () {
		
		return medicinerepository.findAll();
	}
	
	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine>getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
		
		
	Medicine medicine =	medicinerepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with Id"+id));
	
	return ResponseEntity.ok(medicine);
	}
	
	
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> UpdateMedicine(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
		
		Medicine medicine =	medicinerepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with Id"+id));

		medicine.setDrugName(medicineDetails.getDrugName());
		medicine.setStock(medicineDetails.getStock());
		
		medicinerepository.save(medicine);
		
		return ResponseEntity.ok(medicine);    
	}
	
	
	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String , Boolean>> delete (@PathVariable long id) throws AttributeNotFoundException {
		Medicine medicine =	medicinerepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not Found with Id"+id));
		
		medicinerepository.delete(medicine);
		
		Map<String , Boolean> response = new HashMap<String , Boolean> ();
		
		response.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);

	}
}
