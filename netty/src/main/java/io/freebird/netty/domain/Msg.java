package io.freebird.netty.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Msg {

    private String content;

}
