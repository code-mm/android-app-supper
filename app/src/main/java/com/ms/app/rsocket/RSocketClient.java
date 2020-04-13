package com.ms.app.rsocket;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;


public class RSocketClient {

    private String host;
    private Integer port;


    public RSocketClient() {
        Mono<RSocket> rsocket = RSocketFactory.connect()
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .setupPayload(DefaultPayload.create("", ""))
                .dataMimeType("application/json")
                .metadataMimeType("message/x.rsocket.routing.v0")
                .transport(TcpClientTransport.create(host, port))
                .start();
    }


}
