package com.admSystem.financialSystem.controller;

import com.admSystem.financialSystem.data.EntradasSaidasEntity;
import com.admSystem.financialSystem.service.EntradasSaidasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/entradasSaidas")
@CrossOrigin(origins = "*")
public class EntradasSaidasController {

    @Autowired
    EntradasSaidasService entradasSaidasService;

    @GetMapping
    public ResponseEntity<List> getESaidasList() {
        List<EntradasSaidasEntity> eSaidasList = entradasSaidasService.listEntradasSaidas();

        return new ResponseEntity<>(eSaidasList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradasSaidasEntity> getESaidasId(@PathVariable Long id) {
        EntradasSaidasEntity eSaidasId = entradasSaidasService.getEntradasSaidasId(id);

        return new ResponseEntity<>(eSaidasId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntradasSaidasEntity> addESaidas(@RequestBody EntradasSaidasEntity eSaidas) {
        var newUser = entradasSaidasService.createEntradasSaidas(eSaidas);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradasSaidasEntity> attESaidas(@PathVariable Long id, @RequestBody EntradasSaidasEntity eSaidas) {
        var newEsaidas = entradasSaidasService.atualizarES(id, eSaidas);
        return new ResponseEntity<>(newEsaidas, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<EntradasSaidasEntity> deleteESaidas(@PathVariable Long id){
        entradasSaidasService.deleteEntradasSaidasId(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
