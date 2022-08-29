package com.example.LojaAutomoveis;

import com.example.LojaAutomoveis.daoPattern.VeiculoDaoH2;
import com.example.LojaAutomoveis.model.ConfigurarJDBC;
import com.example.LojaAutomoveis.model.Veiculo;
import com.example.LojaAutomoveis.service.JDBCService;
import com.example.LojaAutomoveis.service.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LojaAutomoveisApplicationTests {
	VeiculoService veiculoService;
	Veiculo onix, strada, celta;
	@BeforeEach()
	void load()
	{
		veiculoService = new VeiculoService(new VeiculoDaoH2(new ConfigurarJDBC()));
		onix = new Veiculo("Chevrolet", "Onix", 47990.99f);
		strada = new Veiculo("Fiat", "Strada", 107500.88f);
		celta = new Veiculo("Chevrolet", "Celta", 36550.00f);
	}

	@Test
	void salvarVeiculo()
	{
		veiculoService.salvar(onix);
		veiculoService.salvar(strada);
		veiculoService.salvar(celta);
	}

	@Test
	void buscarVeiculo()
	{
		//Retornando String com dados de todos os veiculos inclusos no banco de dados
		System.out.println(veiculoService.buscar());
	}
}
