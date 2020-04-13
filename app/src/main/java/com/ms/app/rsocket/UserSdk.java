package com.ms.app.rsocket;

import com.ms.common.route.ROUTES;
import com.ms.common.user.login.UserLoginUsernameRequest;

import org.ms.module.supper.client.Modules;

import java.time.Duration;

import io.netty.buffer.Unpooled;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

public class UserSdk {

    // rsocket
    private RSocket rSocket;

    // 主机
    private String host;

    // 端口
    private Integer port;

    // 链接是否打开
    private boolean open;

    // 从新链接次数
    private int reconnect = 5;

    // 当前第几次
    private int connect_count = 0;


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


        Modules.getUtilsModule().getThreadPoolUtils().runSubThread(() -> {
            Mono<RSocket> rsocket = RSocketFactory
                    .connect()
                    .errorConsumer(throwable -> {
                        throwable.printStackTrace();
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
                    .transport(TcpClientTransport.create(host, port))
                    .start();

            try {
                rsocket
                        .blockOptional()
                        .ifPresent(
                                rSocket -> {
                                    UserSdk.this.rSocket = rSocket;
                                    open = true;
                                    Modules.getUtilsModule().getThreadPoolUtils().runOnMainThread(() -> {
                                        if (callBack != null) {
                                            callBack.onSuccess("");
                                        }
                                    });
                                }
                        );
            } catch (Exception e) {
                e.printStackTrace();
                Modules.getUtilsModule().getThreadPoolUtils().runOnMainThread(() -> {
                    if (callBack != null) {
                        callBack.onException(e);
                    }
                });
            }
        });

        return this;
    }


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
                public void onException(Throwable e) {
                    connect(this);
                    connect_count++;
                }
            });
        }
    }
}