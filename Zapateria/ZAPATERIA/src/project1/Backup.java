package project1;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Backup {
    @Id
    public static int nrobackup;
    private Calendar fechaUltimo;
    private String file;
    private int dias;

    public Backup(Calendar fechaUltimo, String file, int dias) {
        this.nrobackup = 1;
        this.fechaUltimo = fechaUltimo;
        this.file = file;
        this.dias = dias;
        Empresa.getPersistencia().insert(this);
    }


    public static void setNrobackup(int nrobackup) {
        Backup.nrobackup = nrobackup;
    }

    public static int getNrobackup() {
        return nrobackup;
    }

    public void setFechaUltimo(Calendar fechaUltimo) {
        this.fechaUltimo = fechaUltimo;
    }

    public Calendar getFechaUltimo() {
        return fechaUltimo;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}

