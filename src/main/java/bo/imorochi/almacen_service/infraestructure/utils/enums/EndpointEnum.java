package bo.imorochi.almacen_service.infraestructure.utils.enums;

public enum EndpointEnum {
    CREATE_COMPROBANTE_CONTABLE("/comprobante"),
    UPDATE_STATE_OBRAS("/solicitud/updatestate")
    ;
    private final String description;

    EndpointEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
