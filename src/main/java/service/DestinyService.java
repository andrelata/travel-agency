package service;

import model.DestinyResponse;

public enum DestinyService {

    INSTANCE;

    /**
     * Une la información que devuelve el servicio de reservas de vuelo y de hoteles y construye un objeto
     * DestinyResponse
     * @param destiny ciudad o pais de destino
     * @return DestinyResponse
     */
    public DestinyResponse getDestinyInfo(final String destiny) {
        DestinyResponse destinyResponse = new DestinyResponse();
        destinyResponse.addReservations(FlightReservationService.INSTANCE.getFlightReservation(destiny));
        destinyResponse.addHotels(HotelService.INSTANCE.getHotels(destiny));
        return destinyResponse;
    }
}
