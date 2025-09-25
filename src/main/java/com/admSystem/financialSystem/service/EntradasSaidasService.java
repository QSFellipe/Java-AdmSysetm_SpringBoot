package com.admSystem.financialSystem.service;

import com.admSystem.financialSystem.data.EntradasSaidasEntity;
import com.admSystem.financialSystem.data.EntradasSaidasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradasSaidasService {
    @Autowired
    EntradasSaidasRepository entradasSaidasRepo;
    
    /*metodo para criar as entradas/saidas*/
    public EntradasSaidasEntity createEntradasSaidas(EntradasSaidasEntity eSaidas){
        eSaidas.setId(null);
        entradasSaidasRepo.save(eSaidas);
        return eSaidas;
    }
    
    /*metodo para criar as entradas/saidas*/
    public EntradasSaidasEntity getEntradasSaidasId(Long eSaidasId){
        return entradasSaidasRepo.findById(eSaidasId).orElse(null);
    }
    
    /*metodo para listar todas as entradas/saidas*/
    public List<EntradasSaidasEntity> listEntradasSaidas(){
        return entradasSaidasRepo.findAll();
    }
    
    /*metodo para atualizar as entradas/saidas*/
    public EntradasSaidasEntity atualizarES (Long eSaidasId, EntradasSaidasEntity eSRequest){
        EntradasSaidasEntity eSEntity = getEntradasSaidasId(eSaidasId);
        
        eSEntity.setCategoria(eSRequest.getCategoria());
        eSEntity.setDataEntrada(eSRequest.getDataEntrada());
        eSEntity.setDataSaida(eSRequest.getDataSaida());
        eSEntity.setDescricao(eSRequest.getDescricao());
        eSEntity.setMetodoPagamento(eSRequest.getMetodoPagamento());
        eSEntity.setValorEntrada(eSRequest.getValorEntrada());
        eSEntity.setValorSaida(eSRequest.getValorSaida());
        
        entradasSaidasRepo.save(eSEntity);
        
        return eSEntity;
        
    }
    /*metodo para deletar as entradas/saidas*/
    public void deleteEntradasSaidasId(Long eSaidasId){
        EntradasSaidasEntity eSEntity = getEntradasSaidasId(eSaidasId);
        
        entradasSaidasRepo.deleteById(eSEntity.getId());
    }
}
