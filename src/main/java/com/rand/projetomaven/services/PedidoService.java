package com.rand.projetomaven.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rand.projetomaven.domain.Pedido;
import com.rand.projetomaven.repositories.PedidoRepository;
import com.rand.projetomaven.services.exceptions.ObjNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido search(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
		  "Object not found! Id:" + id + ", Type: "+ Pedido.class.getName()));			
	}

}
	