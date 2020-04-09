package com.ms.app.view.activity;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


/**
 * RSocket 路由工具类
 */
public class RSocketRouteUtils {
    /**
     * byte[] 类型
     *
     * @param routePath
     * @return
     */
    public static byte[] routeByte(String routePath) {
        byte[] routePathBytes = routePath.getBytes();
        byte[] route = new byte[routePathBytes.length + 1];
        route[0] = (byte) routePathBytes.length;
        for (int i = 0; i < routePathBytes.length; i++) {
            route[i + 1] = routePathBytes[i];
        }
        return route;
    }

    /**
     * ByteBuf 类型
     *
     * @param routePath
     * @return
     */
    public static ByteBuf routeByteBuf(String routePath) {
        byte[] routePathBytes = routePath.getBytes();
        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(routePathBytes.length);
        buf.writeBytes(routePathBytes);
        return buf;
    }
}
