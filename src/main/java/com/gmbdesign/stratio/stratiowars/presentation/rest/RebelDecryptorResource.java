package com.gmbdesign.stratio.stratiowars.presentation.rest;

import com.gmbdesign.stratio.stratiowars.presentation.dto.DecryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.presentation.dto.EncryptedCoordinateListDTO;
import com.gmbdesign.stratio.stratiowars.test.service.IDecryptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coordinates")
public class RebelDecryptorResource {

    @Autowired
    IDecryptorService decryptorService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public DecryptedCoordinateListDTO getCoordinatesDecrypted (EncryptedCoordinateListDTO encryptedCoordinateListDTO) {
        DecryptedCoordinateListDTO decryptedCoordinateListDTO = null;
        decryptedCoordinateListDTO = decryptorService.decryptCoordinateList(encryptedCoordinateListDTO);
        return decryptedCoordinateListDTO;
    }
}
