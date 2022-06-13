package com.pfa.sudodental.service;


import com.pfa.sudodental.model.Consultation;
import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.model.Seance;
import com.pfa.sudodental.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends AbstractService<Patient,Long>{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    protected JpaRepository<Patient, Long> getRepository(){
        return patientRepository;

    }
    public void calculAllMontant(Patient patient){
        for (Consultation consultation : patient.getConsultationSet()){
            float montantC=0;
            for (Seance seance : consultation.getSeanceList()){
                if(seance.getReglement().getDatePayment()!=null) montantC+=seance.getReglement().getMontantPaye();
            }
            consultation.setMontantPaye(montantC);
            if(montantC==consultation.getMontant()) consultation.setEtatReglement(true);
        }
    }

}
