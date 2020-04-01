package service;

import model.Candidat;
import model.Domeniu;
import repository.CandidatRepository;
public class CandidatService {
    private CandidatRepository candidat_repository;

    public CandidatService() {
        candidat_repository = new CandidatRepository();
    }
    public void afisareCandidati(){
        candidat_repository.afisareCandidati();
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu){
        candidat_repository.adaugareCandidat(c, domeniu);
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu[]){
        candidat_repository.adaugareCandidat(c, domeniu);
    }

    public void adaugareCandidat(Candidat c){
        candidat_repository.adaugareCandidat(c);
    }
    public void stergerePozitieCandidat(int index){
        candidat_repository.stergerePozitieCandidat(index);
    }
    public void stergereCandidat(String CNP){
        candidat_repository.stergereCandidat(CNP);
    }
    public int gasireCandidat(String CNP){
        return candidat_repository.gasireCandidat(CNP);
    }
    public Candidat gasireCandidatMedieBacMaxima() {
        return candidat_repository.gasireCandidatMedieBacMaxima();
    }
    public Candidat[] getCopieCandidat(){return candidat_repository.getCopieCandidat();}
    public Candidat[] ordonareMedieExamen(){return candidat_repository.ordonareMedieExamen();}
    public Candidat getCandidatIndex(int index){
        return candidat_repository.getCandidatIndex(index);
    }
    public Candidat[] getCandidat(){
        return candidat_repository.getCandidat();
   }
}
