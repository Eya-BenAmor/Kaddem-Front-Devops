package tn.esprit.spring.khaddem.repositories;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.khaddem.entities.Universite;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;




@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UniversiteRepositoryTest {

    @Autowired
    private UniversiteRepository universiteRepository;
    Universite universite = new Universite();
    @Test
    @Order(0)
    public void testSave() {

    universite=universiteRepository.save(universite);
    System.out.println(universite.toString());
    assertNotNull(universite.getIdUniversite());

    }
    @Test
    @Order(1)
    public void testFindById() {

        Integer existingUniversiteId = universite.getIdUniversite();
        Universite foundUniversite = universiteRepository.findById(existingUniversiteId).orElse(null);
        assertNotNull(foundUniversite);
        assertEquals(existingUniversiteId, foundUniversite.getIdUniversite());
    }
    @Test
    @Order(2)
    public void testDeleteById() {
        Integer universiteIdToDelete = universite.getIdUniversite();
        universiteRepository.deleteById(universiteIdToDelete);
        Universite deletedUniversite = universiteRepository.findById(universiteIdToDelete).orElse(null);
        assertNull(deletedUniversite);
    }


}
