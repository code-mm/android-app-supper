package com.ms.app.view.activity;

import com.ms.common.route.ROUTES;
import com.ms.common.user.User;
import com.ms.common.user.login.UserLoginUsernameRequest;

import org.ms.module.supper.client.Modules;

import java.time.Duration;

import io.netty.buffer.Unpooled;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

public class UserSdk {

    private RSocket rSocket;

    private String host;

    private Integer port;

    private boolean open;

    public boolean open() {
        return open;
    }


    private static UserSdk instance;


    public static UserSdk getInstance() {
        if (instance == null) {
            synchronized (UserSdk.class) {
                instance = new UserSdk();
            }
        }
        return instance;
    }

    private UserSdk() {

    }

    public UserSdk setHost(String host) {
        this.host = host;
        return this;
    }

    public UserSdk setPort(Integer port) {
        this.port = port;
        return this;
    }


    public UserSdk connect(RSocketCallBack callBack) {
        Mono<RSocket> rsocket = RSocketFactory.connect()
                .errorConsumer(throwable -> {
                    open = false;
                    if (callBack != null) {
                        callBack.onException(throwable);
                    }
                })
                // 永不断开
                .keepAliveAckTimeout(Duration.ofDays(1))
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .setupPayload(DefaultPayload.create("", ""))
                .dataMimeType("application/json")
                .metadataMimeType("message/x.rsocket.routing.v0")
                .transport(TcpClientTransport.create("192.168.0.43", 38000))
                .start();
        rsocket
                .blockOptional()
                .ifPresent(
                        rSocket -> {
                            this.rSocket = rSocket;
                            Modules.getUtilsModule().getToastUtils().show("connect success ");
                            open = true;
                            if (callBack != null) {
                                callBack.onSuccess("");
                            }
                        }
                );
        return this;
    }


    private int reconnect = 5;

    private int connect_count = 0;

    public void login(UserLoginUsernameRequest request) {

        if (open) {
            String data = Modules.getUtilsModule().getGsonUtils().toJson(request);
            rSocket.requestResponse(DefaultPayload.create(Unpooled.wrappedBuffer(data.getBytes()), RSocketRouteUtils.routeByteBuf(ROUTES.USER_LOGIN_USERNAME)));

        } else {
            connect(new RSocketCallBack() {
                @Override
                public void onSuccess(Object o) {
                    login(request);
                }

                @Override
                public void onFailure(Object o) {
                    if (connect_count < reconnect) {
                        connect(this);
                    }
                    connect_count++;
                }

                @Override
                public void onCancel(Object o) {

                }

                @Override
                public void onStart(Object o) {

                }

                @Override
                public void onUnknown(Object o) {

                }

                @Override
                public void onException(Object o) {

                }

                @Override
                public void onChange(Object o) {

                }
            });
        }
    }
}