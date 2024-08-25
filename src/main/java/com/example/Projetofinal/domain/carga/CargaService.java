package com.example.Projetofinal.domain.carga;

import com.example.Projetofinal.domain.vendedor.Vendedor;
import com.example.Projetofinal.domain.vendedor.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargaService {

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;
    public Carga registraCarga(DadosCadastroCarga dados){
        Vendedor vendedor = vendedorRepository.findById(dados.idVendedor()).get();

        Carga carga = new Carga(dados);
        carga.setVendedor(vendedor);

        cargaRepository.save(carga);
        return  carga;
    }
}
