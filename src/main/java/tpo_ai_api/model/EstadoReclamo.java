package tpo_ai_api.model;

import javax.persistence.Embeddable;

@Embeddable
public enum EstadoReclamo {
    NUEVO,
    ABIERTO,
    EN_PROCESO,
    DESESTIMADO,
    ANULADO,
    TERMINADO
}
