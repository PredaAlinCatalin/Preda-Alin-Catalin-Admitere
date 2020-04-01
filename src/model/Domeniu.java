package model;

import service.CandidatService;
import service.RezultateAdmitere;

public abstract class Domeniu {
    abstract public void afisareDomeniu();
    abstract public Examen getExamen();
    abstract public void setExamen(Examen examen);
    abstract public CandidatService getCandidat_service();
    abstract public void setCandidat_service(CandidatService candidat_service);
    abstract public RezultateAdmitere getRezultate_admitere();
    abstract public void setRezultate_admitere(RezultateAdmitere rezultate_admitere);

}
