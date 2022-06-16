package com.pfa.sudodental.service;


import com.pfa.sudodental.dto.RdvDTO;
import com.pfa.sudodental.model.Rdv;
import com.pfa.sudodental.repository.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RdvService extends AbstractService<Rdv,Long>{

    @Autowired
    private RdvRepository rdvRepository;

    @Override
    protected JpaRepository<Rdv, Long> getRepository(){
        return rdvRepository;
    }

    public List<Rdv> getFRdvByDate(String date) {
        return rdvRepository.getFRdvByDate(date);
    }
    public List<Rdv> getTRdvByDate(String date) {
        return rdvRepository.getTRdvByDate(date);
    }

    public List<Rdv> getAllNonValid() {
        return rdvRepository.getAllNonValid();
    }
    public List<Rdv> getAllValid() {
        return rdvRepository.getAllValid();
    }


    public int rdvReste(){
        int total=0;
        Date date=new Date();
        SimpleDateFormat formatter_2=new SimpleDateFormat("MM/dd/yyyy");
        List<Rdv> rdvList=this.getFRdvByDate(formatter_2.format(date));
        for(Rdv rdv:rdvList){
            if(rdv.getEtat()==false){
                total=total+1;
            }
        }
        return total;
    }
    public int rdvpasse(){
        int total=0;
        Date date=new Date();
        SimpleDateFormat formatter_2=new SimpleDateFormat("MM/dd/yyyy");
        List<Rdv> rdvList=this.getTRdvByDate(formatter_2.format(date));
        for(Rdv rdv:rdvList){
            if(rdv.getEtat()==true){
                total=total+1;
            }
        }
        return total;
    }


    public List<RdvDTO> toDTO(List<Rdv> rdvs){
        List<RdvDTO>rdvDTOList=new ArrayList<>();
        for (Rdv rdv : rdvs){
            RdvDTO rdvDTO=new RdvDTO();
            rdvDTO.setDateRdv(rdv.getDateRdv());
            rdvDTO.setHeureRdv(rdv.getHeureRdv());
            rdvDTO.setHeureFin(rdv.getHeureFin());
            rdvDTO.setTraitement(rdv.getTraitement());
            rdvDTO.setId(rdv.getPatient().getId().toString());
            rdvDTO.setNomPatient(rdv.getPatient().getNom()+""+rdv.getPatient().getPrenom());
            rdvDTOList.add(rdvDTO);
        }
        return rdvDTOList;
    }
}
