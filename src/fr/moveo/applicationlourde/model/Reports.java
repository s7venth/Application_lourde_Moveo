package fr.moveo.applicationlourde.model;

/**
 * class model Report
 */
public class Reports {
    int idUser, idPicture;

    public Reports() {
    }

    public Reports(int idUser, int idPicture) {
        this.idUser = idUser;
        this.idPicture = idPicture;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "idUser=" + idUser +
                ", idPicture=" + idPicture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reports reports = (Reports) o;

        if (idUser != reports.idUser) return false;
        return idPicture == reports.idPicture;

    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idPicture;
        return result;
    }

    public int getIdUser() {

        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }
}
