package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.Statut;
import tn.esprit.spring.khaddem.entities.Universite;
import tn.esprit.spring.khaddem.repositories.UniversiteRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





@SpringBootTest
public class UniversiteServiceImplTest {

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;



 @Test
    public void testRetrieveAllUniversites() {
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite(1, "Universite 1","Tunis",new Date(), Statut.PRIVEE));
        universites.add(new Universite(2, "Universite 2","Bizerte",new Date(), Statut.PRIVEE));
        Mockito.when(universiteRepository.findAll()).thenReturn(universites);
        List<Universite> result = universiteService.retrieveAllUniversites();
        assertEquals(universites, result);
    }

    @Test
    public void testAddUniversite() {

        Universite universite = new Universite(1, "Universite 1","Tunis",new Date(), Statut.PRIVEE);
        Mockito.when(universiteRepository.save(universite)).thenReturn(universite);
        Universite result = universiteService.addUniversite(universite);
        assertEquals(universite, result);
    }


}

