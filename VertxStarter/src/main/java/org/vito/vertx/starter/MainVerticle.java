package org.vito.vertx.starter;

import io.vertx.core.AbstractVerticle;

/**
 * @author Halb
 * @version V1.0
 * @Title: MainVerticle
 * @Package: org.vito.vertx.starter
 * @Description: TODO
 * @date 2019/06/09 23:35
 */
public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer()
                .requestHandler(req -> req.response().end("Hello Vert.x!"))
                .listen(8080);
    }
}
