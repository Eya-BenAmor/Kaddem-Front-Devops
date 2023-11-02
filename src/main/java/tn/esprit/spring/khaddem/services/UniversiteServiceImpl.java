package tn.esprit.spring.khaddem.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.entities.Universite;
import tn.esprit.spring.khaddem.repositories.DepartementRepository;
import tn.esprit.spring.khaddem.repositories.UniversiteRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UniversiteServiceImpl implements  IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        log.debug("u :"+u.getNomUniv());
        log.debug("u :"+u.getAdresse());
        log.debug("u :"+u.getDateCreation());
        log.debug("u :"+u.getStatut());
        universiteRepository.save(u);
        return u;
    }

    @Override
    public Universite updateUniversite(Universite u, Integer id) {

        Optional<Universite> optionalUniv = universiteRepository.findById(id);
        if (optionalUniv.isPresent()) {
            Universite universite = optionalUniv.get();
            universite.setNomUniv(u.getNomUniv());
            universite.setAdresse(u.getAdresse());
            universite.setDateCreation(u.getDateCreation());
            universite.setStatut(u.getStatut());
            Universite finalU = universiteRepository.save(universite);
            return finalU;
        } else {
            return null;
        }

    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }


    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        Optional<Universite> optionalUniv = universiteRepository.findById(idUniversite);

        if (optionalUniv.isPresent()) {
            Universite universite = optionalUniv.get();
            return universite;
        } else {
            return  null;
        }
    }

    @Transactional
    public void assignUniversiteToDepartement(Integer universiteId, Integer departementId) {
        Optional<Universite> optionalUniv = universiteRepository.findById(universiteId);
        Optional<Departement> optionalDep = departementRepository.findById(departementId);
        if (optionalUniv.isPresent() && optionalDep.isPresent()) {
            Universite universite = optionalUniv.get();
            Departement departement = optionalDep.get();
            universite.getDepartements().add(departement);
            log.info("nombre de departements " + universite.getDepartements().size());
        } else {

            log.error("Impossible d'assigner le département à l'université. Une ou les deux entités n'ont pas été trouvées.");
        }



    }







}
