package kr.co.houmuch.core.domain.common.dto;

import kr.co.houmuch.core.domain.common.jpa.CoordinateJpo;

public record Coordinate(double latitude, double longitude) {
    public static Coordinate of(double latitude, double longitude) {
        return new Coordinate(latitude, longitude);
    }

    public CoordinateJpo asJpo() {
        return new CoordinateJpo(latitude, longitude);
    }
}
