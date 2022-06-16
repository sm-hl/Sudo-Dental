package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Reglement;
import com.pfa.sudodental.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglementService extends AbstractService<Reglement,Long>{

    @Autowired
    private ReglementRepository reglementRepository;

    @Override
    protected JpaRepository<Reglement, Long> getRepository(){
        return reglementRepository;

    }
    public List<Reglement> getAllRPaye(){
       return reglementRepository.getAllRPaye();
    }
    public List<Reglement> getAllDPaye(){
        return reglementRepository.getAllDPaye();
    }

    public float totalVA(){
        float total=0;
        for (Reglement reglement:this.getAllRPaye()){
            total+=reglement.getMontantPaye();
        }
        for (Reglement reglement:this.getAllDPaye()){
            total-=reglement.getMontantPaye();
        }
        return total;
    }
    public float[] chartDepense(String year){
        List<Reglement> depenseList=this.getAllDPaye();
        float [] data=new float[12];
        for (int i=0;i<data.length;i++){data[i]=0;}
        for (Reglement depense : depenseList){
            if(year.equals(depense.getDatePayment().split("/")[2])){
                switch (depense.getDatePayment().split("/")[0]){
                    case "01":data[0]+=depense.getMontantPaye();break;
                    case "02":data[1]+=depense.getMontantPaye();break;
                    case "03":data[2]+=depense.getMontantPaye();break;
                    case "04":data[3]+=depense.getMontantPaye();break;
                    case "05":data[4]+=depense.getMontantPaye();break;
                    case "06":data[5]+=depense.getMontantPaye();break;
                    case "07":data[6]+=depense.getMontantPaye();break;
                    case "08":data[7]+=depense.getMontantPaye();break;
                    case "09":data[8]+=depense.getMontantPaye();break;
                    case "10":data[9]+=depense.getMontantPaye();break;
                    case "11":data[10]+=depense.getMontantPaye();break;
                    case "12":data[11]+=depense.getMontantPaye();break;
                }
            }
        }
        return data;
    }

    public float[] chartRecette(String year){
        List<Reglement> recetteList=this.getAllRPaye();
        float [] data=new float[12];
        for (int i=0;i<data.length;i++){data[i]=0;}
        for (Reglement recette : recetteList){
            if(year.equals(recette.getDatePayment().split("/")[2])){
                switch (recette.getDatePayment().split("/")[0]){
                    case "01":data[0]+=recette.getMontantPaye();break;
                    case "02":data[1]+=recette.getMontantPaye();break;
                    case "03":data[2]+=recette.getMontantPaye();break;
                    case "04":data[3]+=recette.getMontantPaye();break;
                    case "05":data[4]+=recette.getMontantPaye();break;
                    case "06":data[5]+=recette.getMontantPaye();break;
                    case "07":data[6]+=recette.getMontantPaye();break;
                    case "08":data[7]+=recette.getMontantPaye();break;
                    case "09":data[8]+=recette.getMontantPaye();break;
                    case "10":data[9]+=recette.getMontantPaye();break;
                    case "11":data[10]+=recette.getMontantPaye();break;
                    case "12":data[11]+=recette.getMontantPaye();break;
                }
            }
        }
        return data;
    }
}
