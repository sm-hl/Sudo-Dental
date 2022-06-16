package com.pfa.sudodental.service;


import com.pfa.sudodental.model.Consultation;
import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.model.Seance;
import com.pfa.sudodental.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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
    public int[] chartAge(){
     int [] data=new int[6];
     for (int i=0;i<data.length;i++){data[i]=0;}
        List<Patient> patientList=this.getAll();
        for (Patient patient: patientList) {
            //get age
            String [] dateNaiss=patient.getDateNaiss().split("/");
            LocalDate birthdate = LocalDate.of(Integer.parseInt(dateNaiss[2]), Integer.parseInt(dateNaiss[0]), Integer.parseInt(dateNaiss[1]));
            LocalDate now =  LocalDate.now();
            float age = Period.between(birthdate, now).getYears();
            //traitement
            if(age<=18) {data[5]+=1;}
            else if (age<=30){data[0]+=1;}
            else if (age<=40){data[1]+=1;}
            else if (age<=50){data[2]+=1;}
            else if(age<=60){data[3]+=1;}
            else {data[4]+=1;}
        }
        return data;
    }
    public int[] chartSex(){
        int [] data=new int[2];
        for (int i=0;i<data.length;i++){data[i]=0;}
        List<Patient> patientList=this.getAll();
        //traitement
        for (Patient patient: patientList) {
            switch (patient.getSex()){
                case "Masculin":data[0]+=1;break;
                case "Feminin":data[1]+=1;break;
            }
        }
        return data;
    }

}
