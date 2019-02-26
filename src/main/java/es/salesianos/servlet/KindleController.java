package es.salesianos.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Kindle;
import es.salesianos.model.User;
import es.salesianos.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/kindle")
public class KindleController {

	@Autowired
	private Service service;

	@RequestMapping(value = "/delete/{tablename}/", method = RequestMethod.GET)
	public ResponseEntity delete(@PathVariable String tablename, @RequestParam(required = false) Integer id) {
		service.delete(tablename, id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Kindle> create(@RequestBody Kindle kindle) {
		service.insert(kindle);
		return new ResponseEntity<>(kindle, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Kindle>> ListAll() {
		return new ResponseEntity<>(service.listAllKindles(), HttpStatus.CREATED);
	}


}
