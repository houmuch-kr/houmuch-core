package kr.co.houmuch.core.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.houmuch.core.util.JsonUtils;

import java.io.Serializable;

public interface JsonSerializable extends Serializable {
    ObjectMapper objectMapper = new ObjectMapper();

    default String asJson() {
        return JsonUtils.asJson(this);
    }

    default String asPrettyJson() {
        return JsonUtils.asPrettyJson(this);
    }
}
