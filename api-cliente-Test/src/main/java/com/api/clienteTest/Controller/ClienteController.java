package com.api.clienteTest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clienteTest.Documents.Cliente;
import com.api.clienteTest.Repository.ClienteRepository;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		try
		{
			Cliente clienteSave = clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(clienteSave, 
					HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity<String>(e.getCause().toString(), 
					HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllClientes(){
		try
		{
			List<Cliente> allClientes = clienteRepository.findAll();
			return new ResponseEntity<List<Cliente>>(allClientes, 
					HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>(e.getCause().toString(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCliente(@PathVariable("id") int id){
		try
		{
			Optional<Cliente> clientes = clienteRepository.findById(id);
			return new ResponseEntity<Optional<Cliente>>(clientes, 
					HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>(e.getCause().toString(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Cliente cliente){
		try
		{
			Cliente clienteSave = clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(clienteSave, 
					HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>(e.getCause().toString(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		try
		{
			clienteRepository.deleteById(id);
			return new ResponseEntity<String>("", 
					HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>(e.getCause().toString(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	
}
